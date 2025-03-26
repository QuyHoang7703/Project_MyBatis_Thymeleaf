document.addEventListener("DOMContentLoaded", function() {
        console.log("Script loaded!");
    var errorToastEl = document.getElementById("errorToast");
    var successToastEl = document.getElementById("successToast");

    if (errorToastEl) {
        errorToastEl.classList.remove("d-none");
        var errorToast = new bootstrap.Toast(errorToastEl);
        errorToast.show(); // 🚀 GỌI `.show()` để hiển thị
    }

    if (successToastEl) {
        successToastEl.classList.remove("d-none");
        var successToast = new bootstrap.Toast(successToastEl); // 🔥 Khởi tạo đối tượng
        successToast.show(); // 🚀 GỌI `.show()` để hiển thị
    }
});
