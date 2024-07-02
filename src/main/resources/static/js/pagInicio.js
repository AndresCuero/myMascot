function openMenu() {
    let menu = document.getElementById('menu');
    if (menu.classList.contains('hidden')) {
        menu.classList.remove('hidden');
    } else {
        menu.classList.add('hidden');
    }
}

function openNot() {
    let not = document.getElementById('not');
    if (not.classList.contains('hidden')) {
        not.classList.remove('hidden');
    } else {
        not.classList.add('hidden');
    }
}

function openNot2() {
    let not2 = document.getElementById('not2');
    if (not2.classList.contains('hidden')) {
        not2.classList.remove('hidden');
    } else {
        not2.classList.add('hidden');
    }
}

document.getElementById('menuIcon').addEventListener('click', openMenu);
document.getElementById('notificationIcon').addEventListener('click', openNot);
document.getElementById('notificationIcon2').addEventListener('click', openNot2);

