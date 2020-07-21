package com.Advertisement.Advertisement.service;

import com.Advertisement.Advertisement.model.*;
import com.Advertisement.Advertisement.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public Double calculateGradeForAd(Long id) {
        List<Grade> grades = gradeRepository.findAllByAd_Id(id);

        if (grades.isEmpty()) {
            return 0.0;
        }

        Double sum = 0.0;

        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i).getValue();
        }

        return sum / grades.size();
    }

    public void save(Grade grade) {
        gradeRepository.save(grade);
    }
}
