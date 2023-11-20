function openModal(data) {
  const regex = new RegExp("(\\d+) (.*)");
  const matches = regex.exec(data);
  const id = matches[1]
  const text = matches[2]

  // Получаем элемент всплывающего окна
  const modal = document.querySelector(".edit-modal");

  // Отцентрируем всплывающее окно на странице
  modal.style.position = "absolute";
  modal.style.left = "50%";
  modal.style.top = "50%";
  modal.style.transform = "translate(-50%, -50%)";

  // Показать всплывающее окно
  modal.style.display = "block";

  document.querySelector(".modal-task-id").text = id;
  document.querySelector(".modal-text").value = text;
}

function sendModal() {
  const id = document.querySelector(".modal-task-id").text;
  const text = document.querySelector(".modal-text").value.replace(" ", "%20");
  const host = "localhost:8080";
  const url = `http://${host}/api/task/${id}/edit/?text=${text}`;
  const request = new XMLHttpRequest();

  request.open('POST', url);
  request.setRequestHeader('accept', '*/*');

  request.onload = function () {
    if (request.status === 200) {
      // Успех
    } else {
      // Ошибка
    }
  };

  request.send();

  setTimeout(location.reload(), 500);

  closeModal();
}

function closeModal() {
  // Получаем элемент всплывающего окна
  const modal = document.querySelector(".edit-modal");

  // Скрыть всплывающее окно
  modal.style.display = "none";
}
