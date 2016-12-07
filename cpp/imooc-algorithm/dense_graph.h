//
// Created by Jacob su on 12/7/16.
//

#ifndef IMOOC_ALGORITHM_DENSE_GRAPH_H
#define IMOOC_ALGORITHM_DENSE_GRAPH_H

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

namespace graph {
    class dense_graph {
    private:
        int n;
        int m;
        bool directed;
        vector<vector<bool>> g;

    public:
        dense_graph(int n, bool directed) {
            this->n = n;
            this->m = 0;
            this->directed = directed;

            for (int i = 0; i < n; i++) {
                g.push_back(vector<bool>(false));
            }
        }

        ~dense_graph() {

        }

        int v() {
            return n;
        }

        int e() {
            return m;
        }

        void add_edge(int v, int w) {
            assert(v >= 0 && v < n);
            assert(w >= 0 && w < n);

            if (has_edge(v, w)) {
                return;
            }

            g[v][w] = true;
            if (!directed) {
                g[w][v] = true
            }

            m++;
        }

        bool has_edge(int v, int w) {
            assert(v >= 0 && v < n);
            assert(w >= 0 && w < n);

            return g[v][w];
        }
    };

    class sparse_graph {
    private:
        int n;
        int m;
        bool directed;
        vector<vector<int>> g;

    public:
        sparse_graph(int n, bool directed) {
            this->n = n;
            this->m = 0;
            this->directed = directed;

            for (int i = 0; i < n; i++) {
                g.push_back(vector<int>());
            }
        }

        ~sparse_graph() {

        }

        int v() {
            return n;
        }

        int e() {
            return m;
        }

        void add_edge(int v, int w) {
            assert(v >= 0 && v < n);
            assert(w >= 0 && w < n);

            if (has_edge(v, w)) {
                return;
            }
            
            g[v].push_back(w);
            if (v != w && !directed) {
                g[w].push_back(v);
            }

            m++;
        }

        bool has_edge(int v, int w) {
            assert(v >= 0 && v < n);
            assert(w >= 0 && w < n);

            for (int i = 0; i < g[v].size(); ++i) {
                if (g[v][i] == w) {
                    return true;
                }
            }

            return false;
        }
    };
}


#endif //IMOOC_ALGORITHM_DENSE_GRAPH_H
