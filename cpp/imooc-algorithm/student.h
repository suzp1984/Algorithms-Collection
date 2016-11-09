//
// Created by Jacob su on 11/9/16.
//

#ifndef IMOOC_ALGORITHM_STUDENT_H
#define IMOOC_ALGORITHM_STUDENT_H

#include <cxxabi.h>
#include <iostream>
#include <string>

using namespace std;

struct student {
    string name;
    int score;

    bool operator<(const student &otherStudent) {
        return score < otherStudent.score;
    }

    friend ostream& operator<<(ostream &os, const student &student) {
        os << "student: " << student.name << " " << student.score << endl;
        return os;
    }
};

#endif //IMOOC_ALGORITHM_STUDENT_H
