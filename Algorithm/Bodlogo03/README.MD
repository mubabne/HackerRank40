# Extra Long Factorials - HackerRank

## Бодлогын тайлбар

Танд нэг бүхэл тоо `n` өгөгдөнө. Зорилго нь `n!` буюу `n` факториалын утгыг тооцоолон хэвлэх юм. Факториал гэдэг нь:

n! = n × (n-1) × (n-2) × ... × 2 × 1


Жишээлбэл:
25! = 25 × 24 × 23 × ... × 2 × 1

Жирийн `int` болон `long` төрлүүд ийм том тоог хадгалж чадахгүй. Тиймээс том тоонуудыг хадгалах боломжтой `BigInteger` (Java), `BigInt` (JavaScript), `BigInteger`-той тэнцэх төрлийг ашиглах шаардлагатай.

---

## Бодлогын холбоос

[Extra Long Factorials - HackerRank](https://www.hackerrank.com/challenges/extra-long-factorials/problem?isFullScreen=true)

---

## Нотолгоо ба шийдэл

Энгийн цикл ашиглан `n!`-г `BigInteger` ашиглан үржүүлж бодно.

Жишээлбэл (Java дээр):

```java
BigInteger result = BigInteger.ONE;
for (int i = 2; i <= n; i++) {
    result = result.multiply(BigInteger.valueOf(i));
}
System.out.println(result);

Энэ нь маш том n-үүдийн хувьд ч алдаагүй, шууд зөв хариуг гаргах боломжтой.
Жишээ
Оролт:
25

Гаралт:
15511210043330985984000000


## Директор бүтэц

HackerRank
    ├── Algorithm
    |   ├── Bodlogo03
    |   |   ├── ExtraLongFactorials.java
    |   |   └── README.md