# Encryption - HackerRank

## Бодлогын тайлбар

Өгөгдсөн string `s` дээр шифрлэлт хийх шаардлагатай. Үсэг, тоо, тэмдэгтүүдийн хоорондын хоосон зайнуудыг арилгаж, дараа нь тодорхой хэмжээтэй grid хэлбэрт оруулж шифрлэнэ.

Алгоритм:
1. Хоосон зайнуудыг арилгана.
2. `rows` ба `columns`-ыг `sqrt(s.length)` дээр үндэслэн тодорхойлно:
   - `rows = floor(sqrt(L))`
   - `columns = ceil(sqrt(L))`
   - Хэрвээ `rows * columns < L` байвал `rows++`
3. Үүссэн grid-ийн багануудаар уншиж шифрлэгдсэн текст үүсгэнэ.

---

## Бодлогын холбоос

[Encryption - HackerRank](https://www.hackerrank.com/challenges/encryption/problem?isFullScreen=true)

---

## Нотолгоо ба шийдэл

Бүх текстийг нэг мөрөнд оруулж, 2D grid-д тааруулан байрлуулна. Дараа нь баганаар уншин шифрлэсэн текстийг үүсгэнэ. Энэ аргаар текстийг шифрлэж, амархан буцааж тайлж болдог бүтэц бий болдог.

Grid-н логик нь дараах байдлаар ажиллана:
- Эхлээд мөрөөр бичнэ: жишээ нь "haveaniceday"
have
anic
eday


- Дараа нь баганаар уншина: `"hae and via ecy"`

---

## Жишээ

**Оролт:**
haveaniceday


**Гаралт:**
hae and via ecy

HackerRank
   ├──.vscode
   ├──DataStructure
   ├── Algorithm
   |   ├── Bodlogo07
   |   |   ├── Encryption.java
   |   |   └── README.md