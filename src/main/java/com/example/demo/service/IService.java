package com.example.demo.service;

import java.util.List;

public interface IService<C,ID> {
    C create(C c);

    C read(ID id);

    C update(C c);

    void delete(ID id);
    List<C> getAll();
}
