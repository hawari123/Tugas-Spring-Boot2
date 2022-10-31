package id.sinaukoding.latihan.controller;

import id.sinaukoding.latihan.model.Customer;
import id.sinaukoding.latihan.model.Staff;
import id.sinaukoding.latihan.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    private StaffService service;

    @GetMapping("/find-all")
    public ResponseEntity<?> getAllData(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> createData(@RequestBody Staff param){
        Staff data = service.createData(param);

        if (data != null){
            return new ResponseEntity<>(data, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateData(@RequestBody Staff param,
                                        @RequestParam(name = "id") int id){
        Staff data = service.updateData(param, id);

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
