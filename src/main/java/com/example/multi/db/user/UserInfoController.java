package com.example.multi.db.user;

import com.example.multi.db.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/users")
public class UserInfoController {

    private final UserInfoRepository repository;

    @GetMapping
    public Page<UserInfo> findAll(@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
                                  @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                  @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
                                  @RequestParam(name = "sortDirection", defaultValue = "ASC") Sort.Direction direction) {
        PageRequest pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, sortBy));
        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public UserInfo findById(@PathVariable("id") long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("No user with id " + id + " present in the database"));
    }

}
