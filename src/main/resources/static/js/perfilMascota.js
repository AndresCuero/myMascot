
document.addEventListener('DOMContentLoaded', () => {
const carousel = document.getElementById('carousel-images');
const images = carousel.children;
const totalImages = images.length;
let index = 0;

document.getElementById('next').addEventListener('click', () => {
index = (index + 1) % totalImages;
carousel.style.transform = `translateX(-${index * 100}%)`;
});

document.getElementById('prev').addEventListener('click', () => {
index = (index - 1 + totalImages) % totalImages;
carousel.style.transform = `translateX(-${index * 100}%)`;
});
});

    
