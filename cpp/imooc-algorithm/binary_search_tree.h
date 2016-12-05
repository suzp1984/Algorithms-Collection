//
// Created by Jacob su on 12/5/16.
//

#ifndef IMOOC_ALGORITHM_BINARY_SEARCH_TREE_H
#define IMOOC_ALGORITHM_BINARY_SEARCH_TREE_H

#include <iostream>

using namespace std;
namespace binary_search_tree {
    template <typename K, typename V>
    class binary_search_tree {
    private:
        struct Node {
            K k;
            V v;
            Node* left;
            Node* right;

            Node(K key, V value) {
                this->k = k;
                this->v = v;
                this->left = this-> right = NULL;
            }
        };

        Node* root;
        int count;

    public:
        binary_search_tree() {
            root = NULL;
            count = 0;
        }

        ~binary_search_tree() {

        }

        int size() {
            return count;
        }

        bool isEmpty() {
            return count == 0;
        }
    };
}


#endif //IMOOC_ALGORITHM_BINARY_SEARCH_TREE_H
