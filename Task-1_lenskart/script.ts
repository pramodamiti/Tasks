
//# sourceMappingURL=script.js.map

const trendsContainer = document.getElementById("trends");

// Each group contains 4 trend cards
const trendSlides = [
  `
  <div class="trend"><img src="images/specround.webp" alt="trend1"><h3>Round</h3><button>Explore</button></div>
  <div class="trend"><img src="images/spec2cateeye.webp" alt="trend2"><h3>Cat-Eye</h3><button>Explore</button></div>
  <div class="trend"><img src="images/spec3clubmaster.webp" alt="trend3"><h3>Clubmaster</h3><button>Explore</button></div>
  <div class="trend"><img src="images/spec4trans.webp" alt="trend4"><h3>Transparent</h3><button>Explore</button></div>
  `,
  `
  <div class="trend"><img src="images/spec5blend.webp" alt="trend5"><h3>Wayfarer</h3><button>Explore</button></div>
  <div class="trend"><img src="images/spec6clipon.webp" alt="trend6"><h3>Aviator</h3><button>Explore</button></div>
  <div class="trend"><img src="images/spec7airflex.webp" alt="trend7"><h3>Rectangle</h3><button>Explore</button></div>
  <div class="trend"><img src="images/spec8aviator.webp" alt="trend8"><h3>Oversized</h3><button>Explore</button></div>
  `
];

let currentIndex = 0;

const rightBtn = document.querySelector(".trend-btn.right");
if (rightBtn) {
  rightBtn.addEventListener("click", () => {
    currentIndex = (currentIndex + 1) % trendSlides.length;
    if (trendsContainer) {
      trendsContainer.innerHTML = trendSlides[currentIndex] ?? "";
    }
  });
}

document.querySelector(".trend-btn.left")?.addEventListener("click", () => {
  currentIndex = (currentIndex - 1 + trendSlides.length) % trendSlides.length;
  if (trendsContainer) {
    trendsContainer.innerHTML = trendSlides[currentIndex] ?? "";
  }
});