package dev.ceos.springbootbeginner.controller;

import dev.ceos.springbootbeginner.model.Delivery;
import dev.ceos.springbootbeginner.model.DeliveryRepository;

import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController
{
    //@Autowired
    private final DeliveryRepository deliveryRepository;

    public DeliveryController(DeliveryRepository deliveryRepository)
    {
        this.deliveryRepository = deliveryRepository;
    }

    /*
    @GetMapping
    ResponseEntity<Resource<Delivery>> all(){
        List<Resource<Delivery>> deliverys = deliveryRepository.findAll().stream()
                .map(delivery -> new Resource<>(delivery,
                        linkTo(methodOn(DeliveryController.class).one(delivery.getId())).withSelfRel(),
                        linkTo(methodOn(DeliveryController.class).all()).withRel("delivery")))
                .collect(Collectors.toList());

        Resource<Resource<Delivery>> deliveryList = new Resource<Resource<Delivery>>((Resource<Delivery>) deliverys,
                linkTo(methodOn(DeliveryController.class).all()).withSelfRel());
        return new ResponseEntity<Resource<Delivery>>((MultiValueMap<String, String>) deliveryList,HttpStatus.NOT_FOUND);
    }
    */

    @GetMapping
    Resources<Resource<Delivery>> all() {
        List<Resource<Delivery>> deliverys = deliveryRepository.findAll().stream()
                .map(delivery -> new Resource<>(delivery,
                        linkTo(methodOn(DeliveryController.class).one(delivery.getId())).withSelfRel(),
                        linkTo(methodOn(DeliveryController.class).all()).withRel("delivery")))
                .collect(Collectors.toList());

        return new Resources<>(deliverys,
                linkTo(methodOn(DeliveryController.class).all()).withSelfRel());
    }

    @GetMapping("/")
    Resource<Delivery> one(@RequestParam(value="id",required=false) Long id){

        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Exist"));

        return new Resource<>(delivery,
                linkTo(methodOn(DeliveryController.class).one(id)).withSelfRel(),
                linkTo(methodOn(DeliveryController.class).all()).withRel("delivery"));
    }

    @PostMapping
    Delivery newDelivery(@RequestBody Delivery newDelivery){
        return deliveryRepository.save(newDelivery);
    }

    @PatchMapping
    Delivery replaceEmployee(@RequestBody Delivery newDelivery){
        Long id = newDelivery.getId();
        Delivery deliverys = deliveryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("문제가 발생하였습니다."));

        return deliveryRepository.findById(id)
                .map(delivery -> {
                    delivery.updateAddress(newDelivery.getAddress());
                    return deliveryRepository.save(delivery);
                })
                .orElseGet(() -> {
                    newDelivery.updateId(id);
                    return deliveryRepository.save(newDelivery);
                });
    }


    @DeleteMapping
    public ResponseEntity<String> deleteDelivery(@RequestBody Delivery delDelivery){
        Long id = delDelivery.getId();
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("확인되지 않은 주문입니다."));

        deliveryRepository.deleteById(id);
        return  new ResponseEntity("배달이 완료되었습니다.", HttpStatus.OK);
    }


}
