**도서관 사서가 이용하는 검색 프로그램**

**Team-8 권대안, 김아라, 정은진**

## 🗂 Librarian Service Project Github Notion

---

[GitHub - ptkeb/210823_Librarian_Service_Project](https://github.com/ptkeb/210823_Librarian_Service_Project)

[Notion - Librarian_Service_Project](https://bit.ly/3sM8kXh)

## 🛠 모델링

---

![Untitled](https://user-images.githubusercontent.com/85170623/130909073-8155b196-688c-4402-adc5-97ae17eb05d1.png)

## 📂 기능 목록

---

- **Entity**

    <details>
    <summary>BooksDTO</summary>
    <div markdown="1">

    ```java
    @Entity(name = "BOOKS")
    public class BooksDTO {
        @Id
        @Column(name="bookid")
        private int bookId;
        
        @Column(name="bookname")
        private String bookName;
        
        @Column(name="categoryId")
        private String categoryId;
        
        @ManyToOne
        @JoinColumn(name="userId") 
        private UserDTO userId;

        @Override
        public String toString() {
            return "[책 번호] " + bookId + "\n" +
                    "[책 이름] " + bookName + "\n" +
                    "[분류 번호] " + categoryId + "\n" +
                    "[대여자 번호] " + userId.getUserId();
        }
    }
    ```
    </div>
    </details>

    <details>
    <summary>LibrarianDTO</summary>
    <div markdown="1">

    ```java
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter

    @NamedQuery(query="select e from LIBRARIAN e where e.librarianId=:librarianId",name="LIBRARIAN.findByLibrarianId")
    @NamedQuery(query="select e from LIBRARIAN e", name="LIBRARIAN.findAllByLibrarianId")
    @Entity(name = "LIBRARIAN")
    public class LibrarianDTO {
        @Id
        @Column(name = "librarianId")
        private int librarianId;
        
        private String librarianName;
        
        private String offDay;

        @Override
        public String toString() {
            return "[사서 번호] " + librarianId + "\n" +
                    "[사서 이름] " + librarianName + "\n" +
                    "[휴무 요일] " + offDay + "\n";
        }
    }
    ```
    </div>
    </details>

    <details>
    <summary>MainCategoryDTO</summary>
    <div markdown="1">

    ```java
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor

    @Entity(name = "MainCategory")
    @NamedQuery(name = "category.findById", query = "select c from MainCategory c where c.mainCategoryId = :mainCategoryId ")
    @NamedQuery(name = "category.findAllById", query = "select c from MainCategory c")
    public class MainCategoryDTO {
        @Id
        private String mainCategoryId;
        
        private String mainCategoryName;
        
        private int librarianId;
        
        @Override
        public String toString() {
            return "[분류 번호] " + mainCategoryId + "\n" +
                    "[분류 이름] " + mainCategoryName + "\n" +
                    "[담당 사서 번호] " + librarianId + "\n";
        }
    }
    ```
    </div>
    </details>

    <details>
    <summary>UserDTO</summary>
    <div markdown="1">

    ```java
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter

    @NamedQuery(name = "user.findById", query = "select u from LIBUSER u where u.userId = :userId ")
    @NamedQuery(name = "user.findAllById", query = "select u from LIBUSER u")
    @SequenceGenerator(name="member_seq_gen", sequenceName="member_seq_id", initialValue=1, allocationSize=1)

    @Entity(name = "LIBUSER")
    public class UserDTO {
        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="member_seq_gen")
        @Column(name="userid")
        private int userId;
        
        @Column(name="username")
        private String userName;
        
        @Column(name="useraddress")
        private String userAddress;
        
        @OneToMany(mappedBy="userId") 
        private List<BooksDTO> books = new ArrayList<>();
        
        public String toString() {
            return "[사용자 번호] " + userId + "\n" +
                    "[사용자 이름] " + userName + "\n" +
                    "[사용자 주소] " + userAddress + "\n" +
                    "[대여중인 책] " + books + "\n";

        }
    }
    ```
    </div>
    </details>

    <br/>
    

- **SQL Query**
    <details>
    <summary>DDL</summary>

    ```sql
    DROP TABLE BOOKS cascade constraint;
    DROP TABLE LIBRARIAN cascade constraint;
    DROP TABLE LIBUSER cascade constraint;
    DROP TABLE MAINCATEGORY cascade constraint;
    DROP SEQUENCE userId_seq;
    DROP SEQUENCE bookid_seq;

    --LIBUSER DDL
    CREATE SEQUENCE userId_seq
    INCREMENT BY 1 
    START WITH 21;
    CREATE TABLE LIBUSER (
        userId              NUMBER(20)  PRIMARY KEY,
        userName                VARCHAR2(20),
        userAddress             VARCHAR2(20)
    );

    --BOOKS DDL
    CREATE SEQUENCE bookid_seq
    INCREMENT BY 1 
    START WITH 21;
    CREATE TABLE BOOKS (
        bookid              NUMBER(20) PRIMARY KEY,
        bookname                VARCHAR2(100),
        categoryid              VARCHAR2(20),
        userid              NUMBER(20)
    );

    --LIBRARIAN DDL
    CREATE TABLE LIBRARIAN (
        librarianid			NUMBER(20)  PRIMARY KEY,
        librarianname		VARCHAR2(20),
        offday				VARCHAR2(20)
    );

    --MAINCATEGORY DDL
    CREATE TABLE MAINCATEGORY (
        maincategoryid		VARCHAR2(20) PRIMARY KEY,
        maincategoryname	VARCHAR2(20),
        librarianid			NUMBER(20)
    );

    --ALTER TABLE MAINCATEGORY ADD FOREIGN KEY (librarianid) REFERENCES LIBRARIAN (librarianid);
    ALTER TABLE BOOKS ADD FOREIGN KEY (userid)  REFERENCES LIBUSER (userid);
    ALTER TABLE BOOKS ADD FOREIGN KEY (categoryId) REFERENCES MAINCATEGORY (mainCategoryId);
    ```
    <div markdown="1">

    </div>
    </details>

    <details>
    <summary>DML</summary>
    <div markdown="1">
    
    ```sql
    --LIBRARIAN DML
    INSERT INTO LIBRARIAN VALUES(1, '김사서', '수요일');
    INSERT INTO LIBRARIAN VALUES(2, '박사서', '목요일');
    INSERT INTO LIBRARIAN VALUES(3, '홍사서', '금요일');
    INSERT INTO LIBRARIAN VALUES(4, '최사서', '화요일');
    INSERT INTO LIBRARIAN VALUES(5, '우사서', '월요일');

    --MAINCATEGORY DML
    INSERT INTO MAINCATEGORY VALUES('000','총류', 1);
    INSERT INTO MAINCATEGORY VALUES('100','철학', 2);
    INSERT INTO MAINCATEGORY VALUES('200','종교', 3);
    INSERT INTO MAINCATEGORY VALUES('300','사회과학', 1);
    INSERT INTO MAINCATEGORY VALUES('400','자연과학', 2);
    INSERT INTO MAINCATEGORY VALUES('500','기술과학', 3);
    INSERT INTO MAINCATEGORY VALUES('600','예술', 1);
    INSERT INTO MAINCATEGORY VALUES('700','언어', 2);
    INSERT INTO MAINCATEGORY VALUES('800','문학', 3);
    INSERT INTO MAINCATEGORY VALUES('900','역사', 1);

    --LIBUSER DML

    INSERT INTO LIBUSER VALUES(userId_seq.nextval, '권대안' , '서울');
    INSERT INTO LIBUSER VALUES(userId_seq.nextval, '김아라' , '수원');
    INSERT INTO LIBUSER VALUES(userId_seq.nextval, '정은진' , '부산');
    INSERT INTO LIBUSER VALUES(userId_seq.nextval, '신지혜' , '서울');
    INSERT INTO LIBUSER VALUES(userId_seq.nextval, '개발왕' , '수원');
    INSERT INTO LIBUSER VALUES(userId_seq.nextval, '우용' , '부산');
    INSERT INTO LIBUSER VALUES(userId_seq.nextval, '빙봉' , '서울');
    INSERT INTO LIBUSER VALUES(userId_seq.nextval, '홍길동5' , '수원');
    INSERT INTO LIBUSER VALUES(userId_seq.nextval, '홍길동6' , '부산');
    INSERT INTO LIBUSER VALUES(userId_seq.nextval, '홍길동7' , '서울');

    --BOOKS DML
    INSERT INTO BOOKS VALUES(bookid_seq.nextval,'엄마 나는 커서 정은진이 될래요', '000', null);
    INSERT INTO BOOKS VALUES(bookid_seq.nextval,'엄마 나는 커서 권대안이 될래요', '100', null);
    INSERT INTO BOOKS VALUES(bookid_seq.nextval,'엄마 나는 커서 김아라가 될래요', '200', null);
    INSERT INTO BOOKS VALUES(bookid_seq.nextval,'엄마 나는 커서 신지혜가 될래요', '300', null);
    INSERT INTO BOOKS VALUES(bookid_seq.nextval,'엄마 나는 커서 레몬그랩이 될래요', '400', null);
    INSERT INTO BOOKS VALUES(bookid_seq.nextval,'엄마 나는 커서 김혜경(강사님)이 될래요', '500', null);
    INSERT INTO BOOKS VALUES(bookid_seq.nextval,'엄마 나는 커서 개발자가 안 될래요', '600', null);
    INSERT INTO BOOKS VALUES(bookid_seq.nextval,'엄마 나는 커서 백수가 될래요', '700', null);
    INSERT INTO BOOKS VALUES(bookid_seq.nextval,'엄마 나는 커서 부자가 될래요', '800', null);
    INSERT INTO BOOKS VALUES(bookid_seq.nextval,'엄마 나는 커서 뭐가 될란가..', '900', null);

    commit;
    ```

    <br/>
    
    </div>
    </details>
    <br/>


- **Method**

    <details>
    <summary>Books</summary>
    <div markdown="1">



    - 책 조회 & 모든 책 조회

        ```java
        public static BooksDTO getBook(int bookId) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();

        		BooksDTO findBook = (BooksDTO) em.createNamedQuery("BOOKS.findByBookId").setParameter("bookId", bookId).getSingleResult();

        		return findBook;
        	}

        public static List<BooksDTO> getAllBook() {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();

        		List<BooksDTO> findBook = em.createNamedQuery("BOOKS.findAllBooks").getResultList();

        		return findBook;
        	}
        ```

    - 책 추가

        ```java
        public static void addBook(String bookName, String categoryId) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();

        		tx.begin();

        		BooksDTO book = new BooksDTO();
        		book.setBookName(bookName);
        		book.setCategoryId(categoryId);
        		book.setUserId(null); // null 들어가나?

        		em.persist(book);

        		tx.commit();
        	}
        ```

    - 책 정보 변경

        ```java
        public static void updateBookName(int bookId, String bookName) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();

        		tx.begin();

        		BooksDTO book = em.find(BooksDTO.class, bookId);
        		book.setBookName(bookName);

        		em.persist(book);

        		tx.commit();
        	}

        	public static void updateBookCategory(int bookId, String categoryId) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();

        		tx.begin();

        		BooksDTO book = em.find(BooksDTO.class, bookId);
        		book.setCategoryId(categoryId);

        		em.persist(book);

        		tx.commit();
        	}
        ```

    - 책 삭제

        ```java
        public static void deleteBook(int bookId) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();

        		tx.begin();

        		BooksDTO book = em.find(BooksDTO.class, bookId);
        		em.remove(book);
        		
        		tx.commit();
        	}
        ```
    </div>
    </details>
    
    <details>
    <summary>Rent & Return</summary>
    <div markdown="1">
    
    - 책 대출

        ```java
        public static void returnBook(int bookId, int userId) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();

        		tx.begin();

        		UserDTO user = em.find(UserDTO.class, userId);
        		Optional<BooksDTO> bookOpt = (Optional<BooksDTO>) (user.getBooks().stream().filter(v -> v.getBookId() == bookId).findAny());
        		BooksDTO book = bookOpt.get();
        		book.setUserId(null);
        		user.getBooks().remove(book);

        		tx.commit();
        	}
        ```

    - 책 반납

        ```java
        public static void returnBook(int bookId, int userId) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();

        		tx.begin();

        		UserDTO user = em.find(UserDTO.class, userId);
        		Optional<BooksDTO> bookOpt = (Optional<BooksDTO>) (user.getBooks().stream().filter(v -> v.getBookId() == bookId).findAny());
        		BooksDTO book = bookOpt.get();
        		book.setUserId(null);
        		user.getBooks().remove(book);

        		tx.commit();
        	}

        	public static void returnAllBook(int userId) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();
        		List<BooksDTO> B1 = new ArrayList<>();

        		tx.begin();
        		
        		UserDTO user = em.find(UserDTO.class, userId);
        		Object[] book = user.getBooks().stream().filter(v -> v.getUserId().getUserId() == userId).toArray();

        		for (Object i : book) {
        			B1.add((BooksDTO) i);
        		}
        		for (BooksDTO i : B1) {
        			user.getBooks().remove(i);
        			i.setUserId(null);
        		}
        		em.persist(user);
        		
        		tx.commit();
        	}
        ```
    </div>
    </details>

    <details>
    <summary>User</summary>
    <div markdown="1">
    
    - 이용자 조회 & 모든 이용자 조회

        ```java
        public static UserDTO getUser(int id) {
        		EntityManager em = Util.getEntityManager();
        		UserDTO user = em.createNamedQuery("user.findById", UserDTO.class).setParameter("userId", id).getSingleResult();
        		return user;
        	}

        	public static List<UserDTO> getAllUser() {
        		EntityManager em = Util.getEntityManager();
        		List<UserDTO> user = em.createNamedQuery("user.findAllById", UserDTO.class).getResultList();
        		return user;
        	}
        ```

    - 이용자 추가

        ```java
        public static void addUser(String name, String address) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();
        		UserDTO user = new UserDTO();
        		user.setUserName(name);
        		user.setUserAddress(address);
        		user.setBooks(null);
        		
        		tx.begin();
        		
        		em.persist(user);
        		
        		tx.commit();
        	}
        ```

    - 이용자 정보 변경

        ```java
        public static void updateUserAddress(int id, String add) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();
        		
        		tx.begin();
        		
        		UserDTO user = em.find(UserDTO.class, id);
        		user.setUserAddress(add);
        		
        		tx.commit();
        	}

        	public static void updateUserName(int id, String name) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();
        		
        		tx.begin();
        		
        		UserDTO user = em.find(UserDTO.class, id);
        		user.setUserName(name);
        		
        		tx.commit();
        	}
        ```

    - 이용자 삭제

        ```java
        public static void deleteUser(int id) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();
        		
        		tx.begin();
        		
        		UserDTO user = em.find(UserDTO.class, id);
        		em.remove(user);
        		em.flush();
        		
        		tx.commit();
        	}
        ```
    </div>
    </details>


    <details>
    <summary>Librarian</summary>
    <div markdown="1">

    - 사서 조회 & 모든 사서 조회

        ```java
        public static LibrarianDTO getLibrarian(int id) {
        		EntityManager em = Util.getEntityManager();

        		LibrarianDTO librarian = (LibrarianDTO)em.createNamedQuery("LIBRARIAN.findByLibrarianId").setParameter("librarianId", id).getSingleResult();

        		em.close();
        		em = null;

        		return librarian;
        	}

        	public static List<LibrarianDTO> getAllLibrarian() {
        		EntityManager em = Util.getEntityManager();

        		List<LibrarianDTO> librarian = em.createNamedQuery("LIBRARIAN.findAllByLibrarianId", LibrarianDTO.class).getResultList();

        		em.close();
        		em = null;

        		return librarian;
        	}
        ```

    - 사서 추가

        ```java
        public static void addLibrarian(int id, String name, String offday) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();
        		
        		tx.begin();

        		LibrarianDTO Librarian = new LibrarianDTO(id, name, offday);
        		
        		em.persist(Librarian);

        		tx.commit();
        	}
        ```

    - 사서 정보 변경

        ```java
        public static void updateLibrarianName(int librarianId, String librarianName) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();

        		tx.begin();

        		LibrarianDTO librarian = em.find(LibrarianDTO.class, librarianId);
        		librarian.setLibrarianName(librarianName);

        		em.persist(librarian);

        		tx.commit();
        	}

        public static void updateLibrarianOffDay(int librarianId, String offDay) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();

        		tx.begin();

        		LibrarianDTO librarian = em.find(LibrarianDTO.class, librarianId);
        		librarian.setOffDay(offDay);

        		em.persist(librarian);

        		tx.commit();
        	}
        ```

    - 사서 삭제

        ```java
        public static void deleteLibrarian(int id) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();
        		
        		tx.begin();

        		LibrarianDTO librarian = em.find(LibrarianDTO.class, id);
        		em.remove(librarian);
        		
        		em.flush();
        		
        		tx.commit();
        	}
        ```
    </div>
    </details>

    <details>
    <summary>MainCategory</summary>
    <div markdown="1">
    
    - 분류 조회 & 모든 분류 조회

        ```java
        public static MainCategoryDTO getCategory(String id) {
        		EntityManager em = Util.getEntityManager();
        		MainCategoryDTO category = em.createNamedQuery("category.findById", MainCategoryDTO.class).setParameter("mainCategoryId", id).getSingleResult();
        		
        		return category;
        	}

        	public static List<MainCategoryDTO> getAllCategory() {
        		EntityManager em = Util.getEntityManager();
        		List<MainCategoryDTO> category = em.createNamedQuery("category.findAllById", MainCategoryDTO.class).getResultList();
        		
        		return category;
        	}
        ```

    - 분류 정보 변경 ( 담당사서만)

        ```java
        public static void updateCategoryLibrarianId(String id, int librarianId) {
        		EntityManager em = Util.getEntityManager();
        		EntityTransaction tx = em.getTransaction();
        		List<LibrarianDTO> Lib = LibrarianDAO.getAllLibrarian();
        		ArrayList<Integer> list = new ArrayList<>();
        		
        		Lib.forEach(v -> list.add(v.getLibrarianId()));
        		
        		if (list.contains(librarianId)) {
        			tx.begin();
        			
        			MainCategoryDTO category = em.find(MainCategoryDTO.class, id);
        			category.setLibrarianId(librarianId);
        			
        			tx.commit();
        		} else {
        			System.out.println("존재하지 않는 사서번호 입니다.");
        		}
        	}
        ```
    </div>
    </details>





## ⚙️ 기능 구현

---

- Books 구현
    - 책 조회 & 모든 책 조회

        ![책한권조회](https://user-images.githubusercontent.com/85170623/130909132-d84f4a54-909a-4ab3-8ad7-2d5f028d38bc.PNG)


    - 책 추가

        ![책추가1](https://user-images.githubusercontent.com/85170623/130909512-de533930-4583-49c2-80af-86abc47bb431.PNG)

        ![책추가2](https://user-images.githubusercontent.com/85170623/130909514-68466e7a-2a1d-4912-b452-e226991d4a21.PNG)
    - 책 정보 변경

        ![책변경](https://user-images.githubusercontent.com/85170623/130909507-24c4389d-94e0-4553-a92f-6dd60e3593c6.PNG)

    - 책 삭제

        ![책삭제1](https://user-images.githubusercontent.com/85170623/130909508-170efecb-20de-4cff-a032-5795e864d0dc.PNG)

        

- Rent & Return 구현
    - 책 대출

        ![대출1](https://user-images.githubusercontent.com/85170623/130909477-7eebdd46-d6a0-4686-af67-ebee433d6cc5.PNG)

        ![대출2](https://user-images.githubusercontent.com/85170623/130909478-9f83241a-92be-4424-9a19-1b2d5d8449ee.PNG)

        

    - 책 반납

        ![책반납](https://user-images.githubusercontent.com/85170623/130909505-b2a2b50c-b6e3-455e-9cb8-00c2a64fbb75.PNG)

        ![책한권조회](https://user-images.githubusercontent.com/85170623/130909516-2cca4a19-de3a-412a-badf-679fc0993bfb.PNG)

- User 구현
    - 이용자 조회 & 모든 이용자 조회

        ![이용자조회1](https://user-images.githubusercontent.com/85170623/130909497-8fb4dc9f-7282-4a9a-be48-ea10c55a9157.PNG)

    - 이용자 추가

        ![이용자추가1](https://user-images.githubusercontent.com/85170623/130909500-2f7e5e44-f98c-40ea-ba6b-99a2b9c6727d.PNG)
        

    - 이용자 정보 변경

        ![이용자변경1](https://user-images.githubusercontent.com/85170623/130909490-8e7a9400-b52e-4442-b3e4-8ab5c89bd89b.PNG)


    - 이용자 삭제

        ![이용자삭제1](https://user-images.githubusercontent.com/85170623/130909492-fef1ce30-9068-4d94-ac29-52433c68d051.PNG)

        

- Librarian 구현
    - 사서 조회 & 모든 사서 조회

        ![사서조회](https://user-images.githubusercontent.com/85170623/130909487-b2b1b8e6-468f-4228-b4b3-a87b2dbc89bc.PNG)

    - 사서 추가

        ![사서추가](https://user-images.githubusercontent.com/85170623/130909488-f1101f53-2764-4d8c-929e-7239e7816efd.PNG)

    - 사서 정보 변경

        ![사서정보변경1](https://user-images.githubusercontent.com/85170623/130909485-83fbcb23-429c-4f40-ae22-19260e0e19c2.PNG)

    - 사서 삭제

        ![사서삭제](https://user-images.githubusercontent.com/85170623/130909484-7c7d5b92-c5c9-4c20-b5ea-a550a2e49594.PNG)

- Main Category 구현
    - 대분류 조회 & 모든 대분류 조회

        ![대분류조회1](https://user-images.githubusercontent.com/85170623/130909473-82be2132-502d-409e-bafc-49def7edc073.PNG)


    - 대분류 정보 변경

        ![대분류정보변경1](https://user-images.githubusercontent.com/85170623/130909468-41bade13-7f86-4436-b64b-5e9159401a88.PNG)


## 💡 발생 문제

---

- GIT 관련 문제
    1. Branch
        1. gitignore를 제대로 설정하지 않았을때, binary 파일과 설정파일들이 같이 푸시되어 설정된 값이 다른 로컬에서 받아서 사용하였을때, 에러가 발생된다. 따라서 문제가 되는 파일을 gitignore를 통해 미리 무시하게 설정한뒤 진행해야한다.
        2. 툴을 이용하여 작업할 경우, Merge된 Branch가 Remote에 남아 자리를 차지하고 있으므로, Merge가 끝난뒤 필요없는 Branch를 삭제해야 한다.
        3. Branch의 생성시점이 Main에 비해 오래 지난것 같으면 같은 Branch를 사용하는 것보다 새로운 Branch를 생성하는것이 안정적이다.
    2. Merge
        1. Merge를 원할하게 진행하기위해, 코드를 변경할때는 메소드 단위나 클래스 단위로 나뉘어서 작업하는것이 좋으며, 필수적인것 외에는 서로 같은 내용을 건드리지 않게 조심해야한다.
        2. Pull Request를 통한 Merge중 발생한 Complict는 매우 간단한것은 온라인상에서 작업이 가능하지만 아니라면 VSC에서 작업하여야 빠르게 작업가능
        3. 필요하지않은 Binary파일이나 설정정보가 변경된 항목에 같이 올라올경우, 깃허브 데스크탑에서는 해당 변경사항을 Discard하여 버리고 해당 브랜치의 원본 파일로 대체할수있으므로, 무작정 Commit하지말고 필요없는것은 확인후 삭제
        4. pull request를 받을때 Complict때문에 Merge가 안된다면 깃허브 데스크탑에서는 상위 탭중 Branch 탭에서 Merge into current branch를 이용하여 해당 Branch를 직접 Merge하는 작업을 불러올 수 있고, VSC를 사용하여 Complict를 확인하고 사용할 코드를 선택하거나, cmd에서 깃 명령어를 통해 Merge를 진행하면서 Complict를 수정하여야 한다.
- Table간의 관계 관련 문제
    1. 분류(MainCategory)테이블과 사서(Librarian)테이블을 FK 지정을 통해 종속 관계로 설정하려 하였으나, 사서테이블의 데이터 삭제 시 에러 발생 → 임시방편으로 FK를 설정하지 않고, 프로젝트 진행함
    2. 두 테이블이 종속되어있지 않으므로, 사서데이터를 삭제할 때, 분류(MainCategory)테이블의 담당사서번호(`librarianId`)를 먼저 삭제해주어야 했음
    3. 종속 관계로 설정한 뒤 담당사서번호(`librarianId`)에 자동으로 `null`값이 들어갈 수 있도록 수정 예정
    4. Detached ~ 예외가 나오는 경우가 생겨서 이것을 해결하기위해 여러 방법을 시도하였음 (CascadeType 등등) 해결이 되지않아서, 포기하고 Sequence를 이용하여  번호를 넣는 작업을 하다가, 해당 문제가 해결된것을 확인함, PK를 가진 요소를 추가하려고할때 문제가 발생한다면 해당 요소의 PK를 Sequence로 만드는 것을 시도하면 좋을것 같음 
- Sequence 관련 문제
    1. Sequence를 부여하여 DB상에 테이블을 생성하였는데, JPA로 데이터를 추가하면 Sequence가 제대로 부여되지 않는 문제 발생 (엉뚱한 Sequence를 부여한다거나, 이미 존재하는 Sequence를 부여하여 에러 발생)
    2. DB상의 테이블을 생성할 때 Sequence를 함께 생성했다면, JPA에서의 `@SequenceGenerator` 사용 여부는 어떻게 되는지 더 알아볼 필요가 있음
