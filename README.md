**도서관 사서가 이용하는 검색 프로그램**

**8조 권대안, 김아라, 정은진**

## 🗂 Librarian Service Project Github

---

[GitHub - ptkeb/210823_Librarian_Service_Project](https://github.com/ptkeb/210823_Librarian_Service_Project)

## 🛠 모델링

---

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9c43b93f-9554-4112-8757-f4c79d1af44f/Untitled.png)

## 📂 기능 목록

---

- **Entity**
    - **BooksDTO**

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

    - **LibrarianDTO**

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

    - **MainCategoryDTO**

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

    - **UserDTO**

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

- **Books**
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

- **Rent & Return**
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

- **User**
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

- **Librarian**
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

- **MainCategory**
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

## ⚙️ 기능 구현

---

- Books 구현
    - 책 조회 & 모든 책 조회

        ![책한권조회.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/83e663ea-23ab-42f8-a446-679ecacd22eb/책한권조회.png)

        ![모든책조회1.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3dd23fc7-c502-4677-b685-0707a131c43f/모든책조회1.png)

        ![모든책조회2.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/23d8beb0-639a-49ea-8afa-4da131ddf111/모든책조회2.png)

    - 책 추가

        ![책추가1.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c8bb04fe-500d-40e1-b112-218535326659/책추가1.png)

        ![책추가2.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2db30732-298b-4e4e-9b58-37b371cb8860/책추가2.png)

    - 책 정보 변경

        ![책변경.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7722aa57-5ff5-46dd-844d-3a183f84c7be/책변경.png)

    - 책 삭제

        ![책삭제1.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/05f37b52-ebbc-410d-bb5a-9b41b9fa7f7a/책삭제1.png)

        ![책삭제3.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/294193e5-81d5-4960-8e5b-e41fe5a862d7/책삭제3.png)

- Rent & Return 구현
    - 책 대출

        ![대출1.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/df47b8e6-ecaa-4590-8759-894dadbc73e5/대출1.png)

        ![대출2.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e94a9912-e03a-46d5-a4d8-e553800f8662/대출2.png)

        ![대출3.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/08d54b13-93af-46b7-8005-659656b7796a/대출3.png)

    - 책 반납

        ![책반납.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/10cfa464-4aeb-4a08-9bcd-0f68c120557b/책반납.png)

        ![책한권조회.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6010e491-1fc5-436d-be7f-c506e8877df2/책한권조회.png)

- User 구현
    - 이용자 조회 & 모든 이용자 조회

        ![이용자조회1.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5c614237-0651-485e-9b5c-c12c07b11062/이용자조회1.png)

        ![이용자조회2.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d2720de4-baff-4896-a952-7fd9956bd0e7/이용자조회2.png)

    - 이용자 추가

        ![이용자추가1.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f5741dac-20a6-4595-88a3-a8dff9bc1e2f/이용자추가1.png)

        ![이용자추가2.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c626e0d0-7d59-464c-a298-40feb7d2c2b4/이용자추가2.png)

    - 이용자 정보 변경

        ![이용자변경.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/55ba8081-6083-4f6e-824c-30ac1daed258/이용자변경.png)

        ![이용자변경2.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/24eec9c4-2bfd-457b-be99-ac05b962c0a7/이용자변경2.png)

    - 이용자 삭제

        ![이용자삭제1.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/01d41bad-13f9-47e9-9a29-76a67c7f25be/이용자삭제1.png)

        ![이용자삭제2.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a54ce62d-29da-4254-9a78-ab8d4d6cd2d3/이용자삭제2.png)

- Librarian 구현
    - 사서 조회 & 모든 사서 조회

        ![사서조회.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d95d4ce2-fe0f-4a89-ac60-6eba8e529939/사서조회.png)

    - 사서 추가

        ![사서추가.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ae234a8b-9f07-48c2-8aa2-efebdd1ede1a/사서추가.png)

    - 사서 정보 변경

        ![사서정보변경.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4652185c-29d1-4d96-a62c-1d7bbd7f778d/사서정보변경.png)

        ![사서정보변경2.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e56b370c-2fcc-450f-bb11-3dee3a3348b5/사서정보변경2.png)

    - 사서 삭제

        ![사서삭제.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/02a4b993-e2fd-4184-9927-fdd771648e7e/사서삭제.png)

- Main Category 구현
    - 대분류 조회 & 모든 대분류 조회

        ![대분류조회1.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/09460b02-48fd-4991-b53d-c00fe405b01a/대분류조회1.png)

        ![대분류조회2.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5eb56817-f4bf-4ec2-86d4-91119e28a387/대분류조회2.png)

    - 대분류 정보 변경

        ![대분류정보변경1.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4ddaec6b-587b-4825-bf05-3ebf5c47fd57/대분류정보변경1.png)

        ![대분류정보변경2.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c910022c-f1a9-4204-a5a5-07930b356578/대분류정보변경2.png)

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