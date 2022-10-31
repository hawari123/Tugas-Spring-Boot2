package id.sinaukoding.latihan.controller;

import id.sinaukoding.latihan.model.Customer;
import id.sinaukoding.latihan.model.Order;
import id.sinaukoding.latihan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/find-all")
    public ResponseEntity<?> getAllData(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createData(@RequestBody Order param){
        Order data = service.createData(param);

        if (data != null){
            return new ResponseEntity<>(data, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateData(@RequestBody Order param,
                                        @RequestParam(name = "id") int id){
        Order data = service.updateData(param, id);

        if (data != null){
            return new ResponseEntity<>(data, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteData(@PathVariable int id){
        if (service.deleteData(id)){
            return new ResponseEntity<>("Delete Sukses", HttpStatus.OK);
        }

        return new ResponseEntity<>("Delete Gagal", HttpStatus.BAD_REQUEST);
    }
}
