#include <iostream>
#include <vector>
using namespace std;

void printMatrix(const vector<vector<int>>& matrix) {
    for (const auto& row : matrix) {
        for (int num : row) {
            cout << num << " ";
        }
        cout << endl;
    }
}

vector<vector<int>> transposeMatrix(const vector<vector<int>>& matrix, int rows, int cols) {
    vector<vector<int>> transposed(cols, vector<int>(rows));
    
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            transposed[j][i] = matrix[i][j];
        }
    }
    
    return transposed;
}

int main() {
    int rows, cols;
    
    cout << "Rows: ";
    cin >> rows;
    cout << "Columns: ";
    cin >> cols;
    
    vector<vector<int>> matrix(rows, vector<int>(cols));
    cout << "Matrix:" << endl;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            cin >> matrix[i][j];
        }
    }
    
    cout << "\nOriginal matrix:" << endl;
    printMatrix(matrix);
    
    vector<vector<int>> transposed = transposeMatrix(matrix, rows, cols);
    cout << "\nTransposed matrix:" << endl;
    printMatrix(transposed);
    
    return 0;
}