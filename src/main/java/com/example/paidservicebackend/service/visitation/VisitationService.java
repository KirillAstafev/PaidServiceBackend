package com.example.paidservicebackend.service.visitation;

import com.example.paidservicebackend.model.Visitation;

import java.util.List;

public interface VisitationService {
    List<Visitation> findAll();
    Integer save(Visitation visitation);
    void update(Visitation visitation);
    void delete(Integer visitationId);
}
