cmake_minimum_required(VERSION 3.6)
project(imooc_algorithm)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES main.cpp student.h sort_help.h sort_help.cpp element_sort.h heap.h binary_search.h binary_search_tree.h union_find.h dense_graph.h)
add_executable(imooc_algorithm ${SOURCE_FILES})