## [Candy](https://leetcode.com/problems/candy/)

### Problem

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

- Each child must have at least one candy.
- Children with a higher rating get more candies than their neighbors.

### Solution


### Code

``` Java
public class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;
        int amount = 1, last = 1, falling = 0;
        for (int i = 1; i < length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (falling > 0) {
                    amount += falling * (falling + 1) / 2;
                    if (falling >= last) {
                        amount += falling - last + 1;
                    }
                    falling = 0;
                    last = 1;
                }
                last = ratings[i] == ratings[i - 1] ? 1 : last + 1;
                amount += last;
            } else {
                falling++;
            }
        }
        if (falling > 0) {
            amount += falling * (falling + 1) / 2;
            if (falling >= last) {
                amount += falling - last + 1;
            }
        }
        return amount;
    }
}
```

### Refinement
