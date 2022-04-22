package com.midterm.BonkRemastered.services;

import com.midterm.BonkRemastered.dto.ProductDTO;
import com.midterm.BonkRemastered.dto.RecordDTO;
import com.midterm.BonkRemastered.dto.UserDTO;

import java.util.List;

public interface RecordService {
    List<RecordDTO> list();

    void add(RecordDTO record);

    RecordDTO get(Long id);

    void update(RecordDTO updatedRecord);

    void delete(Long id);

    void compute(Long id, RecordDTO recordDTO, UserDTO userDTO, ProductDTO productDTO);


}
