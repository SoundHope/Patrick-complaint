package com.example.Patrickcomplaint.service;

import com.example.Patrickcomplaint.entity.Complaint;

import java.util.List;

public interface ComplaintService {
    Complaint register(Complaint newComplaint);
    List<Complaint> getAll();
}
