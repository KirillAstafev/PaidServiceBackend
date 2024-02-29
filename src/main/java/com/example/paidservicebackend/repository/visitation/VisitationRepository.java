package com.example.paidservicebackend.repository.visitation;

import com.example.paidservicebackend.model.Visitation;

import java.util.List;

public interface VisitationRepository {
    List<Visitation> findAll();
    Integer save(Visitation visitation);
    void update(Visitation visitation);
    void delete(Integer visitationId);
}
