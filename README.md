# QLNhaHang_BTL_N5
Bài tập lớn java nhóm 5: Phòng, Hường, Dương, Đông, Phương. Sử dụng JDK8, CSDL sql server, giao diện java swing

# Kế hoạch thực hiện
- Xem <a href="https://docs.google.com/document/d/1GRV8ElFv6Ote6WgxW3kCbah45tdwqAF8DRRIrLl0EoM/edit#heading=h.gjdgxs">tại đây<a/>
# Drive tổng
- Xem tổng <a href="https://drive.google.com/drive/folders/1bl7tHfw05fzWNC1hJT0v4-o7NaHtrxLT?usp=sharing">tại đây<a/>
# JDK 8
- Tải <a href="https://drive.google.com/drive/folders/1_cDOMcMuY1kJFKepoISo5mPRXuyASlX3?usp=sharing">tại đây</a>
# Netbean 8.2
- Tải <a href="https://drive.google.com/file/d/184Uq9aInvIFZZ5MpntGoDLnTFCvqejyb/view?usp=sharing">Tại đây</a>
# Quy trình sử dụng git
## Tóm tắt quy trình:
- Clone code về repository ở máy local
- Cd đến thư mục chứa code
- Checkout sang một nhánh mới để làm việc (lưu ý: mỗi một tính năng là một nhánh mới)
- Sau khi thay đổi, code xong ta sẽ add code và tạo commit
- Checkout sang nhánh develop để pull code mới nhất về
- Checkout ngược lại sang nhánh ta đang làm việc
- Đứng ở đây rebase với nhánh develop để đồng bộ code, nếu xảy ra conflict sẽ xử lý ở bước này
- Push code lên và tạo pull request
	
## Các câu lệnh tương ứng:
- git clone
- git checkout -b feature
- git add .
- git commit -m “fix api get all user”
- git checkout develop
- git pull origin develop
- git checkout feature
- git rebase develop (rebase với nhánh develop để đồng nhất code mới nhất)
Nếu xảy conflict thì vào xem lại code bị conflict, sửa code, sau đó thực  hiện 2 lệnh sau (Nếu k bị conflict thì bỏ qua):
	+ git add .
	+ git rebase –continue
Sau khi xử lý xong conflict:  
- git push origin feature 
- Tạo pull request trên remote gitlab
