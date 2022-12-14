package id.sinaukoding.latihan.service;


import id.sinaukoding.latihan.model.Order;
import id.sinaukoding.latihan.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<Order> findAll(){
        List<Order> data = repository.findAllByIsDeleted(false);

        return data;
    }
    @Transactional
    public Order createData(Order param){
        param.setCreatedDate(new Date());
        param.setDeleted(false);
        return repository.save(param);
    }

    @Transactional
    public Order updateData(Order param, int id){
        Order data = repository.findById(id).get();

        if (data != null){
            data.setOrderDate(param.getOrderDate() != null ? param.getOrderDate() : data.getOrderDate());
            data.setOrderStatus(param.getOrderStatus() != null ? param.getOrderStatus() : data.getOrderStatus());
            data.setRequiredDate(param.getRequiredDate() != null ? param.getRequiredDate() : data.getRequiredDate());
            data.setShippedDate(param.getShippedDate() != null ? param.getShippedDate() : data.getShippedDate());
            data.setUpdatedDate(new Date());

            return repository.save(data);
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        Order data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }
}