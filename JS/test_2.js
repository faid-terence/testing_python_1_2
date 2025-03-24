function decipher(encryptedText, knownWord) {
  function shiftChar(char, shift) {
    if (!/[a-zA-Z]/.test(char)) return char;

    const isUpper = char === char.toUpperCase();
    const base = isUpper ? 65 : 97;
    const code = char.charCodeAt(0);
    return String.fromCharCode(((code - base - shift + 26) % 26) + base);
  }

  const encryptedWords = encryptedText.split(/\s+/);

  for (let word of encryptedWords) {
    const encryptedChar = word[0].toLowerCase().charCodeAt(0);
    const knownChar = knownWord[0].toLowerCase().charCodeAt(0);
    const shift = (encryptedChar - knownChar + 26) % 26;

    let testWord = "";
    for (let char of word) {
      testWord += shiftChar(char, shift);
    }

    if (testWord.toLowerCase() === knownWord.toLowerCase()) {   
      let decrypted = "";
      for (let char of encryptedText) {
        decrypted += shiftChar(char, shift);
      }
      return decrypted;
    }
  }

  return "Unable to decipher";
}

console.log(decipher("Khoor Zruog", "Hello"));
console.log(decipher("Qefp fp x pqzobq", "This"));
