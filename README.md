# Hệ thống quản lí trao tặng từ thiện

## Nhóm FourLittleDucks xin chào: 
| Tên                        | MSSV     | Sdt        | Phân công | Đánh giá |
|----------------------------|----------|------------|-----------|----------|
| Trịnh Gia Huy(nhóm trưởng) | 20520556 | 0941510664 |           | 100%     |
| Lê Thị Thanh Hương(tester) | 20520201 | 0703264721 |           | 100%     |
| Nguyễn Hoàng Nhật          | 20520673 | 0389479682 |           | 100%     |
| Trần Văn Quang             | 20520722 | 0375665412 |           | 100%     |


## Giới thiệu về đồ án
<p align="center">
    Quản lý hệ thống hỗ trợ từ thiện - HeartBeat
</p>
Hiện nay, nước ta có rất nhiều tổ chức từ thiện và người hỗ trợ đang hoạt động để giúp đỡ những người có hoàn cảnh khó khăn và đòi hỏi sự quản lý chặt chẽ về thông tin người cần giúp đỡ và phần gây quỹ của tổ chức đòi hỏi tính minh bạch cao. Để đảm bảo tất cả các công việc trên được thực hiện một cách chuẩn xác nhất thì cần một hệ thống cơ sở dữ liệu quản lý tổ chức từ thiện. Ngoài ra hệ thống này là nơi xây dựng một cộng đồng của sự sẻ chia, nơi con người trao nhau những giá trị cao đẹp, xây dựng một môi trường sống tốt đẹp nơi mọi người cùng học tập nhau những điều tốt, lan tỏa năng lượng tích cực cho xã hội. Dự án cũng nhằm thúc đẩy giảm thiểu lượng rác thải còn có thể được sử dụng ra môi trường, đặc biệt là những rác thải khó xử lý hay những loại rác thải thực phẩm vốn chưa hết vòng đời sử dụng. Dự án cũng giúp xóa dần đi khoảng cách giàu nghèo, giúp những người vốn đang thiếu thốn về cái ăn cái mặc có thêm niềm tin để lao động. </br> 
Hệ thống này cho phép người đang gặp khó khăn về kinh tế hay thiếu thốn vật chất kêu gọi hỗ trợ cho chính mình và người hỗ trợ hoặc các tổ chức từ thiện có thể đi giúp đỡ những hoàn cảnh đó. Ngoài ra, hệ thống còn hỗ trợ tính năng gây quỹ mang tính minh bạch cao để nâng cao lòng tin của người dân. Người dân sử dụng hệ thống này cần đăng ký và đăng nhập, cập nhật thông tin cá nhân để phục vụ cho việc đăng bài hỗ trợ. 
</br>

## Các chức năng có trong ứng dụng
#### Chức năng chung
> * Đăng nhập, đăng ký tài khoản
> * Tạo một bài viết 
> * updating
#### Chức năng của người quản trị viên
> * Quản lí tài khoản người dùng
> * updating

## Các công nghệ, nền tảng đã sử dụng
> * Ngôn ngữ lập trình: Java
> * Công cụ lập trình giao diện: Java Swing
> * Cơ sở dữ liệu: Oracle
> 
## Các chức năng, công nghệ mới(ngoài phạm vi môn học)
> * Chức năng xóa mềm: khi một bài đăng được xóa, nó sẽ không bị xóa hẳn khỏi cơ sở dữ liệu mà sẽ được lưu vào thư mục thùng rác và tồn tại trong 2 ngày, nếu người dùng không thực hiện khôi phục, bài đăng sẽ bị xóa thực sự khỏi cơ sở dữ liệu
> * Chức năng lưu ảnh: ảnh thực sự được lưu vào cơ sở dữ liệu Oracle dưới dạng BLOB.
> * Chức năng bảo mật: Sử dụng Kĩ thuật băm MD5 để băm mật khẩu của người dùng, tránh các rủi ro về bảo mật cho người dùng
> * Sử dụng Regex để kiểm tra các ràng buộc đối với các trường dữ liệu 
> * Chức năng khôi phục mật khẩu: Sử dụng JavaMail để thực hiện việc gửi mail tự động khi người dùng có nhu cầu khôi phục lại mật khẩu
## Cách thức cài đặt chương trình
> * Bước 1: Clone lại project với bằng các các ide như vs code với http:.. hoặc sstp:..
> * Bước 2: Chạy project với NetBean, lúc này NetBean hiển thị thông báo xảy ra lỗi đối với các thư viện chưa có trên máy.
> * Bước 3: Chọn resolve và chọn đường dẫn tới file jdbc11.jar để cài đặt jdbc. Tương tự chọn đường dẫn đến file KGradientPanel.jar để cài đặt thư viện hỗ trợ việc tạo hình ảnh có màu gradient.

