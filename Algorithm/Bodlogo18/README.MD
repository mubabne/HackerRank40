# Fraudulent Activity Notifications - HackerRank

## Бодлогын тайлбар

Худалдан авалтын өдөр тутмын түүх өгөгдөнө. Тухайн өдөр хэрэглэгчийн зардал нь өмнөх `d` хоногийн медианы хоёр дахин их байвал сэжигтэй гэж үзэн анхааруулга илгээнэ.

Зорилго нь: нийт хэдэн анхааруулга илгээгдэхийг тооцоолох.

---

## Бодлогын холбоос

[Fraudulent Activity Notifications - HackerRank](https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?isFullScreen=true)

---

## Нотолгоо ба шийдэл

1. `count` нэртэй 0–200 хүртэл индекс бүхий массив ашиглан sliding window-д histogram үүсгэнэ.
2. Медианыг хурдан тооцоолохын тулд `count[]`-ийг ашиглана:
   - Сондгой тохиолдолд — дундах элемент
   - Тэгш тохиолдолд — хоёр дундах элементийн дундаж
3. Өдөр бүр `expenditure[i] >= 2 * median` бол notification тоог нэмнэ.
4. Sliding window-оос хуучин элемент хасч, шинэ элементийг нэмнэ.

---

## Жишээ

**Оролт:**
9 5
2 3 4 2 3 6 8 4 5


**Гаралт:**
2

## Директор бүтэц
HackerRank
   ├──.vscode
    ├──DataStructure
    ├── Algorithm
    |   ├── Bodlogo18
    |   |   ├── FraudulentActivity.java
    |   |   └── README.md