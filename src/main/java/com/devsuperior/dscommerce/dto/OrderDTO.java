package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;

    private ClientDTO client;

    private PaymentDTO payment;

    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO(Long id, OrderStatus status,  Instant moment,ClientDTO client, PaymentDTO payment) {
        this.id = id;
        this.status = status;
        this.moment = moment;
        this.client = client;
        this.payment = payment;
    }

    public OrderDTO(Order entity) {
        id = entity.getId();
        status = entity.getStatus();
        moment = entity.getMoment();
        client = new ClientDTO(entity.getClient());
        payment = (entity.getPayment() == null )? null : new PaymentDTO(entity.getPayment());

        for(OrderItem item :entity.getItems()){
            OrderItemDTO dto = new OrderItemDTO(item);
            items.add(dto);
        }
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public Double getTotal(){
        double sum =0.0;
        for(OrderItemDTO item : items){
            sum += item.getSubTotal();
        }
        return sum;
    }
}