//
// Created by Jacob su on 12/6/16.
//

#ifndef IMOOC_ALGORITHM_UNION_FIND_H
#define IMOOC_ALGORITHM_UNION_FIND_H

#include <iostream>
#include <cassert>

namespace union_find1 {

    class UnionFind {

    private:
        int *id;
        int count;

    public:
        UnionFind(int n) {
            count = n;
            id = new int[n];

            for (int i = 0; i < n; ++i) {
                id[i] = i;
            }
        }

        ~UnionFind() {
            delete[] id;
        }

        int find(int p) {
            assert(p >= 0 && p < count);
            return id[p];
        }

        bool is_connected(int q, int p) {
            assert(q >= 0 && q < count);
            assert(p >= 0 && p < count);

            return id[q] == id[p];
        }

        void union_elements(int p, int q) {
            int pId = find(p);
            int qId = find(q);

            if (pId == qId) {
                return;
            }

            for (int i = 0; i < count; ++i) {
                if (id[i] == pId)
                    id[i] = qId;
            }
        }
    };
}

namespace union_find2 {
    class UnionFind {
    private:
        int *id;
        int count;

    public:
        UnionFind(int n) {
            count = n;
            id = new int[n];

            for (int i = 0; i < n; ++i) {
                id[i] = i;
            }
        }

        ~UnionFind() {
            delete[] id;
        }

        int find(int p) {
            assert(p >= 0 && p < count);
            while (p != id[p]) {
                p = id[p];
            }

            return p;
        }

        bool is_connected(int q, int p) {
            return find(q) == find(p);
        }

        void union_elements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot) {
                return;
            }

            id[pRoot] = qRoot;
        }
    };
}

#endif //IMOOC_ALGORITHM_UNION_FIND_H
