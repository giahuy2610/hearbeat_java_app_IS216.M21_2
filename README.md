# Hệ thống quản lí trao tặng từ thiện

## Nhóm FourLittleDucks xin chào: 
| Tên                        | MSSV     | Sdt        | Phân công | Đánh giá |
|----------------------------|----------|------------|-----------|----------|
| Trịnh Gia Huy(nhóm trưởng) | 20520556 | 0941510664 |Chức năng           | 9/10     |
| Lê Thị Thanh Hương(tester) | 20520201 | 0703264721 |Kiểm thử, ireport, phần thống kê, thiết kế UI, thêm-sửa-xem bài viết, lưu ảnh bằng blob, jfreechart, đóng gói ứng dụng thành file Jar     | 8/10     |
| Nguyễn Hoàng Nhật          | 20520673 | 0389479682 |Dữ liệu mẫu, đổi icon, thiết kế UI, vẽ class diagram          | 5/10     |
| Trần Văn Quang             | 20520722 | 0375665412 |(UI Đăng nhập,đăng ký,quản trị viên,thông báo,trang cá nhân), dữ liệu mẫu, sửa lỗi giao diện(nhiều lần), thiết kế UI,  vẽ class diagram         | 7/10     |


## Giới thiệu về đồ án
<p align="center">
    Quản lý hệ thống hỗ trợ từ thiện - HeartBeat
</p>
Hiện nay, nước ta có rất nhiều tổ chức từ thiện và người hỗ trợ đang hoạt động để giúp đỡ những người có hoàn cảnh khó khăn và đòi hỏi sự quản lý chặt chẽ về thông tin người cần giúp đỡ và phần gây quỹ của tổ chức đòi hỏi tính minh bạch cao. Để đảm bảo tất cả các công việc trên được thực hiện một cách chuẩn xác nhất thì cần một hệ thống cơ sở dữ liệu quản lý tổ chức từ thiện. Ngoài ra hệ thống này là nơi xây dựng một cộng đồng của sự sẻ chia, nơi con người trao nhau những giá trị cao đẹp, xây dựng một môi trường sống tốt đẹp nơi mọi người cùng học tập nhau những điều tốt, lan tỏa năng lượng tích cực cho xã hội. Dự án cũng nhằm thúc đẩy giảm thiểu lượng rác thải còn có thể được sử dụng ra môi trường, đặc biệt là những rác thải khó xử lý hay những loại rác thải thực phẩm vốn chưa hết vòng đời sử dụng. Dự án cũng giúp xóa dần đi khoảng cách giàu nghèo, giúp những người vốn đang thiếu thốn về cái ăn cái mặc có thêm niềm tin để lao động. </br> 
Hệ thống này cho phép người đang gặp khó khăn về kinh tế hay thiếu thốn vật chất kêu gọi hỗ trợ cho chính mình và người hỗ trợ hoặc các tổ chức từ thiện có thể đi giúp đỡ những hoàn cảnh đó. Ngoài ra, hệ thống còn hỗ trợ tính năng gây quỹ mang tính minh bạch cao để nâng cao lòng tin của người dân. Người dân sử dụng hệ thống này cần đăng ký và đăng nhập, cập nhật thông tin cá nhân để phục vụ cho việc đăng bài hỗ trợ. 
</br>

## Các chức năng có trong ứng dụng
#### Chức năng chung
> * Đăng nhập, đăng ký tài khoản, khôi phục mật khẩu
> * Trang chủ xem bài viết, lọc bài viết theo danh mục, địa chỉ, thời gian
> * Lưu trữ thông báo, lịch hẹn
> * Đặt lịch hẹn, hủy lịch hẹn, xem thông tin người hẹn v.v
> * Thêm, xóa, sửa bài viết
> * Trang cá nhân (xem thông tin người dùng, bài viết đã đăng/đã quan tâm, cập nhật lại thông tin tài khoản v.v)

#### Chức năng của người quản trị viên
> *  Hỗ trợ quản trị viên (quản lý thông tin người dùng, bài viết, thống kê hiệu quả hoạt động của ứng dụng (số bài viết/người dùng mới, số lượt hỗ trợ thành công, sơ đồ tăng trưởng v.v)

## Mô hình dữ liệu quan hệ của ứng dụng
![image](https://user-images.githubusercontent.com/87313146/174045456-a4f984fd-5391-498d-b639-f92efeab214d.png)

## Mô hình phân lớp giao diện ứng dụng
![288462633_1081661599423622_7667761579378514039_n](https://user-images.githubusercontent.com/87313146/175537961-22fa7954-4002-492d-91cd-2fec54e245f5.jpg)


## Các công nghệ, nền tảng đã sử dụng
> * Ngôn ngữ lập trình: Java
> * Công cụ lập trình giao diện: Java Swing
> * Cơ sở dữ liệu: Oracle
> * Công cụ quản lý: Github, Trello

## Các chức năng, công nghệ mới(ngoài phạm vi môn học)
> * Chức năng xóa mềm: khi một bài đăng được xóa, nó sẽ không bị xóa hẳn khỏi cơ sở dữ liệu mà sẽ được lưu vào thư mục thùng rác và tồn tại trong 2 ngày, nếu người dùng không thực hiện khôi phục, bài đăng sẽ bị xóa thực sự khỏi cơ sở dữ liệu.
> * Chức năng lưu ảnh: ảnh thực sự được lưu vào cơ sở dữ liệu Oracle dưới dạng BLOB thay vì dạng đường dẫn tương đối/tuyệt đối.
> * Chức năng bảo mật: Sử dụng Kĩ thuật băm MD5 để băm mật khẩu của người dùng, tránh các rủi ro về bảo mật cho người dùng
> * Chức năng khôi phục mật khẩu: Sử dụng JavaMail để thực hiện việc gửi mail tự động khi người dùng có nhu cầu khôi phục lại mật khẩu.
> * Đóng gói project dưới dạng jar
> 
## Cách thức cài đặt chương trình
> * Bước 1: Clone lại project với bằng các các ide như vs code với http:[..](https://github.com/giahuy2610/java_IS216.M21_2.git) hoặc sstp:..
> * Bước 2: Chạy project với NetBean, lúc này NetBean hiển thị thông báo xảy ra lỗi đối với các thư viện chưa có trên máy.
> * Bước 3: Chọn resolve và chọn đường dẫn tới folder Resource/file_jar trong cùng folder project, chọn các file .jar cần resolve tương ứng.
> * Bước 4: Cài đặt thành công cơ sở dữ liệu Oracle và tạo cơ sở dữ liệu với file sql trong folder SQL.
> * Bước 5: Thực hiện chạy file main trong folder main để mở trang giao diện đăng nhập/đăng ký. Thực hiện đăng ký mới một tài khoản (không tự insert vì dữ liệu mật khẩu được lưu dưới dạng hash và chỉ được hash khi thực hiện đăng ký trên chính ứng dụng). Đăng nhập để sử dụng các chức năng của ứng dụng.

