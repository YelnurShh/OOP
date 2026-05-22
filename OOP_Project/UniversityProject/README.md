# Research-Oriented University System

## Жоба туралы

Бұл жоба - KBTU-ның research-oriented университет жүйесінің Java тілінде жасалған имплементациясы. Жоба OOP принциптерін, design pattern-дерді, collections-ты, exceptions-ты, serialization-ды толық қолданады.

## Жобаның құрылымы

```
UniversityProject/
├── src/
│   ├── Main.java                    # Console демо
│   ├── enums/                       # 9 enum
│   ├── interfaces/                  # Observer, Observable, Researcher
│   ├── exceptions/                  # LowHIndexException, NotResearcherException
│   ├── comparators/                 # ByDate, ByCitations, ByPages
│   ├── factory/                     # UserFactory
│   ├── database/                    # Database (Singleton)
│   └── models/                      # 17 model class
├── data/                            # serialization үшін
└── README.md
```

## Compile & Run

```bash
cd UniversityProject
javac -d out src/Main.java src/**/*.java
java -cp out Main
```

немесе:

```bash
cd UniversityProject
mkdir -p out
javac -d out -sourcepath src src/Main.java
java -cp out Main
```

## Test accounts (барлық пароль: 1234)

| Email | Role |
|-------|------|
| admin@kbtu.kz | Admin |
| mgr@kbtu.kz | Manager (Department) |
| dean@kbtu.kz | Manager (OR / Dean) |
| erlan@kbtu.kz | Teacher (Professor + Researcher) |
| gulnara@kbtu.kz | Teacher (Tutor) |
| hasan@kbtu.kz | Teacher (Senior Lector) |
| ivan@kbtu.kz | Student |
| kamila@kbtu.kz | Student |
| liza@kbtu.kz | GraduateStudent (Master) |
| nurlan@kbtu.kz | GraduateStudent (PhD) |
| support@kbtu.kz | Tech Support |
| petr@kbtu.kz | Researcher Employee |

## Design Patterns

1. **Singleton** - `Database` класы (бір ғана instance, барлық деректер сақталады)
2. **Observer** - `Journal` (Observable) және `User` (Observer). Жаңа paper жарияланғанда subscribers-ке хабарлама жіберіледі.
3. **Factory** - `UserFactory` (User объектілерін roles-ге қарай жасайды)
4. **Strategy / Comparator** - `ByDate`, `ByCitations`, `ByPages` (paper-лерді сұрыптауға)
5. **Memento (Data Storage)** - `Database.saveData()` / `loadData()` (Serialization арқылы)

## Implemented Functionality

### Authentication
- Login арқылы кез келген қолданушы жүйеге кіреді

### Admin
- Add / Remove / Update users
- View log files

### Manager
- Assign courses to teachers
- Approve student registrations
- Add courses for registration
- Create statistical reports (GPA, fails, etc.)
- Manage news
- View students sorted by GPA
- View teachers info
- View employee requests / complaints

### Teacher
- View / Manage courses
- Put marks (1st att, 2nd att, final)
- View students of course
- Send complaint to dean (LOW / MEDIUM / HIGH urgency)
- Send messages
- **Researcher**: publish paper, calculate h-index, print papers (sorted), join project, get citation (PLAIN_TEXT / BIBTEX)

### Student
- View / Register courses (max 21 credits, max 3 fails enforced)
- View marks, transcript (with GPA)
- Rate teachers (1-5)
- Join student organizations
- Send messages

### GraduateStudent (extends Student, implements Researcher)
- All Student features
- Set supervisor (LowHIndexException if h-index < 3)
- Submit diploma papers
- All Researcher features (publish, h-index, print, join project)

### TechSupportSpecialist
- View new requests
- Accept / Reject / Mark as Done
- Status: VIEWED → ACCEPTED / REJECTED → DONE

### ResearcherEmployee
- Researcher-employee, neither teacher nor student
- All Researcher features

## Course Types
- MAJOR (school-specific, SITE student-ке Oil and Gas-тан major бола алмайды)
- MINOR
- FREE_ELECTIVE (SITE student үшін Oil and Gas курсы free elective болуы мүмкін)

## Lesson Types
- LECTURE
- PRACTICE (бір курста бөлек instructor болуы мүмкін)

## Languages
- KZ, EN, RU (қолданушы өзгерте алады)

## Important Constraints
- Студент 21 credit-тен артық ала алмайды
- Студент 3 реттен артық fail жасай алмайды
- Mark = Att1 + Att2 + Final
- Supervisor h-index >= 3 болуы керек

## News
- "Research" topic автоматты түрде pin-деледі
- Жаңа paper жарияланғанда автоматты түрде [NEWS] хабарламасы жасалады

## Exceptions
- `LowHIndexException` - supervisor-дың h-index-і 3-тен аз болғанда
- `NotResearcherException` - Researcher емес адам ResearchProject-ке қосылғанда

## Serialization
- `data/university.ser` файлында бүкіл жүйе сақталады
- "Save & exit" таңдағанда сақталады
- Программа қайтадан іске қосылғанда автоматты түрде жүктеледі
