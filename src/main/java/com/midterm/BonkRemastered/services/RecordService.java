package com.midterm.BonkRemastered.services;

import com.midterm.BonkRemastered.dto.RecordDTO;

import java.util.List;

public interface RecordService {
    List<RecordDTO> list();

    void add(RecordDTO record);

    RecordDTO get(Long id);

    void update(RecordDTO updatedRecord);

    void delete(Long id);
}
