def is_valid_string(s):
    if len(s) < 6:
        return False
    digits = [char for char in s if char.isdigit()]
    if len(digits) < 2 or len(digits) > 3:
        return False
    digit_positions = []
    for i, char in enumerate(s):
        if char.isdigit():
            digit_positions.append(i)
    
    for i in range(len(digit_positions) - 1):
        if digit_positions[i + 1] - digit_positions[i] <= 1:
            return False
    
    return True

test_cases = [
    "abc1de2f",   
    "a1b2c3d",     
    "abcdef",     
    "a1b2c3d4e",  
    "ab12cde",    
    "abc1d",       
]

print("String Validation Test Results:")
for test in test_cases:
    print(f"'{test}' is {'valid' if is_valid_string(test) else 'invalid'}")