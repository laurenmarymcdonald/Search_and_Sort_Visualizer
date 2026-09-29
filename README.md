# Search and Sort Visualizer

A Java and [Processing](https://processing.org/) app that shows **selection sort** and **binary search** running step by step on a small dataset: time spent on social media, by platform.

![Visualizer screenshot](screenshot.png)

## Controls
| Key | Action |
|---|---|
| **Enter** | Start, or show the instructions again |
| **0–9** | Set the search target (hours on social media) |
| **S** | Run selection sort on the dataset |
| **Space** | Take one binary search step |

While the search runs, the current lower and upper bounds are shown in white and the midpoint in green.

## How it works
- The data loads from `src/Data/EffectsofSocialMedia.csv` into `SocialMedia` objects, which implement `Comparable`.
- Selection sort uses `findMin` and `swap` helpers.
- Binary search is written two ways, iteratively and recursively. The UI uses the iterative version so each step can be shown.

## Running it
1. Open the project in IntelliJ IDEA.
2. Add Processing's `core.jar` as a library.
3. Run `Main`.
