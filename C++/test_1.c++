#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector<string> formatText(vector<string>& words, int maxWidth) {
    vector<string> result;
    vector<string> currentLine;
    int currentLength = 0;
    
    for (const string& word : words) {
        if (word.length() > maxWidth) {
            if (!currentLine.empty()) {
                string line;
                for (int i = 0; i < currentLine.size(); i++) {
                    line += currentLine[i];
                    if (i < currentLine.size() - 1) line += " ";
                }
                result.push_back(line);
            }
            result.push_back(word);
            currentLine.clear();
            currentLength = 0;
            continue;
        }
        
        int spaceNeeded = currentLine.empty() ? 0 : 1;
        if (currentLength + word.length() + spaceNeeded <= maxWidth) {
            currentLine.push_back(word);
            currentLength += word.length() + spaceNeeded;
        } else {
            if (!currentLine.empty()) {
                string line;
                for (int i = 0; i < currentLine.size(); i++) {
                    line += currentLine[i];
                    if (i < currentLine.size() - 1) line += " ";
                }
                result.push_back(line);
            }
            currentLine = {word};
            currentLength = word.length();
        }
    }
    
    if (!currentLine.empty()) {
        string line;
        for (int i = 0; i < currentLine.size(); i++) {
            line += currentLine[i];
            if (i < currentLine.size() - 1) line += " ";
        }
        result.push_back(line);
    }
    
    return result;
}

int main() {
    vector<string> words = {"This", "is", "an", "example", "of", "text", "justification."};
    int maxWidth = 10;
    
    vector<string> formatted = formatText(words, maxWidth);
    for (const string& line : formatted) {
        cout << line << endl;
    }
    
    return 0;
}