//
// Created by Jacob su on 12/5/16.
//

#ifndef IMOOC_ALGORITHM_BINARY_SEARCH_TREE_H
#define IMOOC_ALGORITHM_BINARY_SEARCH_TREE_H

#include <iostream>
#include <queue>
#include <cassert>

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

            Node(Node* node) {
                this->k = node->k;
                this->v = node->v;
                this->left = node->left;
                this->right = node->right;
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
            destroy(root);
        }

        int size() {
            return count;
        }

        bool isEmpty() {
            return count == 0;
        }

        void insert(K key, V value) {
            root = insert(root, key, value);
        }

        bool contain(K key) {
            return contain(root, key);
        }

        V* search(K key) {
            return search(root, key);
        }

        void pre_order(void (*action)(K key, V value)) {
            pre_order(root, action);
        }

        void in_order(void (*action)(K key, V value)) {
            in_order(root, action);
        }

        void post_order(void (*action)(K key, V value)) {
            post_order(root, action);
        }

        void level_order(void (*action)(K key, V value)) {
            queue<Node*> q;

            if (root != NULL) {
                q.push(root);
            }

            while (!q.empty()) {
                Node* node = q.front();
                q.pop();

                action(node->k, node->v);
                if (node->left) {
                    q.push(node->left);
                }

                if (node->right) {
                    q.push(node->right);
                }
            }
        }

        K minimum() {
            assert(count != 0);
            Node* node = minimum(root);
            return node->k;
        }

        K maximum() {
            assert(count != 0);
            Node* node = maximum(root);

            return node->k;
        }

        void removeMin() {
            if (root != NULL)
                removeMin(root);
        }

        void removeMax() {
            if (root != NULL) {
                removeMax(root);
            }
        }

        void remove(K key) {
            root = remove(root, key);
        }

    private:
        Node* insert(Node* node, K key, V value) {
            if (node == NULL) {
                count++;
                return new Node(key, value);
            }

            if (key == node->k) {
                node->v = value;
            } else if (key < node->k) {
                node->left = insert(node->left, key, value);
            } else {
                node->right = insert(node->right, key, value);
            }

            return node;
        }

        bool contain(Node* node, K key) {
            if (node == NULL) {
                return false;
            }

            if (node->k == key) {
                return true;
            } else if (key < node->k) {
                return contain(node->left, key);
            } else {
                return contain(node->right, key);
            }
        }

        V* search(Node* node, K key) {
            if (node == NULL) {
                return NULL;
            }

            if (node->k == key) {
                return &(node->v);
            } else if (key < node->k) {
                return search(node->left, key);
            } else {
                return search(node->right, key);
            }
        }

        void pre_order(Node* node, void (*action)(K key, V value)) {
            if (node != NULL) {
                action(node->k, node->v);
                pre_order(node->left, action);
                pre_order(node->right, action);
            }
        }

        void in_order(Node* node, void (*action)(K key, V value)) {
            if (node != NULL) {
                in_order(node->left, action);
                action(node->k, node->v);
                in_order(node->right, action);
            }
        }

        void post_order(Node* node, void (*action)(K key, V value)) {
            if (node != NULL) {
                post_order(node->left, action);
                post_order(node->right, action);
                action(node->k, node->v);
            }
        }

        void destroy(Node* node) {
            if (node != NULL) {
                destroy(node->left);
                destroy(node->right);

                delete node;
                count --;
            }
        }

        Node* minimum(Node* node) {
            if (node->left == NULL) {
                return node;
            }

            return minimum(node->left);
        }

        Node* maximum(Node* node) {
            if (node->right == NULL) {
                return node;
            }

            return maximum(node->right);
        }

        Node* removeMin(Node* node) {
            if (node->left == NULL) {
                Node* rightNode = node->right;
                delete node;
                count --;

                return rightNode;
            }

            node->left = removeMin(node->left);
            return node;
        }

        Node* removeMax(Node* node) {
            if (node->right == NULL) {
                Node* left = node->left;
                delete node;
                count --;
                return left;
            }

            node->right = removeMax(node->right);

            return node;
        }

        Node* remove(Node* node, K key) {
            if (node == NULL) {
                return NULL;
            }

            if (key < node->k) {
                node->left = remove(node->left, key);
                return node;
            } else if (key > node->k) {
                node->right = remove(node->right, key);
                return node;
            } else {
                if (node->left == NULL) {
                    Node* right = node->right;
                    delete node;
                    count--;
                    return right;
                }

                if (node->right == NULL) {
                    Node* left = node->left;
                    delete node;
                    count --;
                    return left;
                }

                Node* successor = new Node(minimum(node->right));

                successor->right = removeMin(node->right);
                successor->left = node->left;
                delete node;
                count--;

                return successor;
            }
        }
    };
}


#endif //IMOOC_ALGORITHM_BINARY_SEARCH_TREE_H
