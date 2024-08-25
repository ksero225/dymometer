package com.dymometr.Dymometr.mapper;

public interface Mapper <classA, classB>{
    classB mapTo(classA a);
    classA mapFrom(classB b);
}
