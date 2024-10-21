$(document).ready(function() {
    // 상품 수정하기 버튼 클릭 시 이벤트 핸들러
    $('#editItemBtn').on('click', function() {
        // 선택된 상품의 ID를 가져와서 editItem.html로 이동
        const selectedItem = $('.edit-item').first(); // 예시: 첫 번째 아이템 선택 (필요 시 수정 가능)
        const itemId = selectedItem.data('id');

        if (itemId) {
            window.location.href = `/main/mypage/editItem?id=${itemId}`;
        } else {
            alert('수정할 상품을 선택해주세요.');
        }
    });

    // 상품 목록의 각 항목을 클릭 시 활성화
    $('.edit-item').on('click', function() {
        $('.edit-item').removeClass('selected');
        $(this).addClass('selected');
    });
});
