# Sherlock and the Valid String - HackerRank

## Бодлогын тайлбар

Нэг string өгөгдөнө. Зорилго нь: тухайн string дэх бүх тэмдэгтүүд **ижил тоогоор** давтагдаж байвал эсвэл **нэг тэмдэгтийг хасахад** ижил давтамжтай болгох боломжтой бол `YES`, боломжгүй бол `NO` гэж хэвлэх.

## Бодлогын холбоос

[Sherlock and the Valid String - HackerRank](https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?isFullScreen=true)

---

## Нотолгоо ба шийдэл

1. Тэмдэгт бүрийн давтамжийг тооцно.
2. Давтамж бүр хэдэн удаа гарч байгааг `Map<Integer, Integer>`-д хадгална.
3. Тооцооны дараа:
   - Хэрвээ зөвхөн 1 төрлийн давтамж байвал → `YES`
   - Хэрвээ 2 төрлийн давтамж байвал:
     - Нэг нь `1` ба ганц удаа гарсан → `YES`
     - Давтамжуудын зөрүү `1` бөгөөд их давтамж нь ганц удаа гарсан → `YES`
   - Бусад тохиолдолд → `NO`


## Жишээ

**Оролт:**
aabbccddeefghi


**Гаралт:**
NO

## Директор бүтэц
HackerRank
    ├──.vscode
    ├──DataStructure
    ├── Algorithm
    |   ├── Bodlogo20
    |   |   ├── SherlockValidString.java
    |   |   └── README.md