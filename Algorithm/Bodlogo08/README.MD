# Bigger is Greater - HackerRank

## Бодлогын тайлбар

Өгөгдсөн string `w` дээр дараагийн хамгийн жижиг бөгөөд `w`-с том үг (лексикографик хувилбар)-ийг олох шаардлагатай. Хэрвээ боломжгүй бол `"no answer"` гэж буцаана.

Зорилго нь: өгөгдсөн string-ийн хамгийн ойрын дараагийн том хувилбарыг олох.


## Бодлогын холбоос

[Bigger is Greater - HackerRank](https://www.hackerrank.com/challenges/bigger-is-greater/problem?isFullScreen=true)


## Нотолгоо ба шийдэл

Алгоритм:
1. Баруунаас зүүн рүү харж, `chars[i] < chars[i + 1]` гэсэн анхны байрлалыг хайна.
2. Олдохгүй бол `"no answer"` буцаана.
3. Тухайн `i`-с хойш `chars[j] > chars[i]` байхаас хамгийн сүүлийнхийг олж, байрлалуудыг солино.
4. `i+1`-ээс хойшх хэсгийг эрэмбэлнэ (`sort`).

Энэ нь "lexicographically next permutation" буюу дараагийн хамгийн ойрын хувилбарыг олох greedy арга юм.


## Жишээ

**Оролт:**
ab
bb
hefg
dhck
dkhc


**Гаралт:**
ba
no answer
hegf
dhkc
hcdk

## Директор бүтэц
HackerRank
    ├── Algorithm
    |   ├── Bodlogo08
    |   |   ├── BiggerIsGreater.java
    |   |   └── README.md
