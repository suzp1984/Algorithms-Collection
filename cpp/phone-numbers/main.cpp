#include <iostream>
#include <vector>
#include <string>
#include <cassert>

using namespace std;

class PhoneNumber {
private:
    const string letterTable[10] = {
            "",       // 0
            "",       // 1
            "ABC",    // 2
            "DEF",    // 3
            "GHI",    // 4
            "JKL",    // 5
            "MNO",    // 6
            "PQRS",   // 7
            "TUV",    // 8
            "WXYZ"    // 9
    };

    vector<string> res;

    void find(const string &digits, const int index, const string &s) {
        if (index == digits.size()) {
            res.push_back(s);
            return;
        }

        char c = digits[index];
        assert(c >= '0' && c <= '9');

        string letters = letterTable[c-'0'];
        if (letters.size() == 0) {
            find(digits, index+1, s);
            return;
        }

        for (int i = 0; i < letters.size(); i++) {
            find(digits, index+1, s + letters[i]);
        }

        return;
    }

public:
    vector<string> find(string digits) {
        res.clear();

        if (digits == "") {
            return res;
        }

        find(digits, 0, "");

        return res;
    }
};

class WordDictionary {

private:
    const static int MAX = 26;
    typedef struct node {
        struct node *next[MAX];
        bool isWordEnd;
    } Node;

    Node* head = createNode();

    Node* createNode() {
        Node* p = new Node();
        for (int i = 0; i < MAX; i++) {
            p->next[i] = NULL;
        }

        p->isWordEnd = false;
        return p;
    }

public:
    void insert(vector<string> words) {
        for (int i = 0; i < words.size(); i++) {
            insert(words[i]);
        }
    }

    void insert(string word) {
        Node* p = head;
        Node* t = NULL;
        for (int i = 0; i < word.size(); i++) {
            int d = word[i] - 'A';
            if (p->next[d] == NULL) {
                t = createNode();
                p->next[d] = t;
                p = p->next[d];
            } else {
                p = p->next[d];
            }
        }

        p->isWordEnd = true;
    }

    bool isExist(string word) {
        Node* p = head;

        for (int i = 0; i < word.size(); ++i) {
            int d = word[i] - 'A';
            if (p->next[d] == NULL) {
                return false;
            } else {
                p = p->next[d];
            }
        }

        return p->isWordEnd;
    }
};

int main() {

    vector<string> res = PhoneNumber().find("2013");
    for (int i = 0; i < res.size(); i++) {
        cout << res[i] << endl;
    }

    WordDictionary dict = WordDictionary();
    dict.insert("AD");

    cout << "AD exist in dict: " << dict.isExist("AD") << endl;
    cout << "AM exist in dict: " << dict.isExist("AM") << endl;

    return 0;
}