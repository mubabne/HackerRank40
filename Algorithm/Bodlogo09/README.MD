# The Time in Words - HackerRank

## Бодлогын тайлбар

Танд цаг (`h`) болон минут (`m`) өгөгдөнө. Үүнийг англи үгээр илэрхийлж хэвлэх шаардлагатай. Жишээлбэл, 5 цаг 28 минут бол `"twenty eight minutes past five"` гэж буух ёстой.


## Бодлогын холбоос

[The Time in Words - HackerRank](https://www.hackerrank.com/challenges/the-time-in-words/problem?isFullScreen=true)


## Нотолгоо ба шийдэл

Минутын утгыг шалгаж англи хэлний өгүүлбэр бүтээх логик:

- `m == 0`: `"five o' clock"`
- `m == 15`: `"quarter past five"`
- `m == 30`: `"half past five"`
- `m == 45`: `"quarter to six"`
- `m < 30`: `"twenty eight minutes past five"`
- `m > 30`: `"twenty minutes to six"`

`m > 30` үед цаг 1-р нэмэгдэж уншигдана (`h + 1`).


## Жишээ

**Оролт:**
5
28

**Гаралт:**
twenty eight minutes past five


**Оролт:**
5
45


**Гаралт:**
quarter to six

## Директор бүтэц
HackerRank
    ├── Algorithm
    |   ├── Bodlogo09
    |   |   ├── TimeInWords.java
    |   |   └── README.md