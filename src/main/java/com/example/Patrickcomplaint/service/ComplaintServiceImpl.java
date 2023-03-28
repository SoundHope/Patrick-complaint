package com.example.Patrickcomplaint.service;

import com.example.Patrickcomplaint.entity.Complaint;
import com.example.Patrickcomplaint.repository.ComplaintRepository;

public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public Complaint register(Complaint newComplaint) {
        return complaintRepository.save(newComplaint);
    }
}
