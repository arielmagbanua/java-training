# Speedy, Still Not, Gonzales

Recall that the general speed limits in the Philippines in 60 km/h on most highways and 100 km/h on expressways.
Let's add a minimum speed when one is in an expressway and that minimum speed limit is 40 km/h.
Your goal here is to compute the speed of automobiles based on distance travelled and time taken to cover this distance.
And at the same time, whether the driver is over-speeding, within speed limit, or under-speeding.

Instructions:

* The input is composed of 3 positive integers representing the road the driver is on (1 for highway, 2 for expressway), distance traveled in meters, and the number of minutes it took to cover the given distance.
* The output should contain the computer speed in km/h (two decimal places) and the status as to whether the driver is over-speeding, within-speed-limit, or under-speeding.

Test cases:

```shell
1 2500 356
0.42 within-speed-limit

2 2500 356
0.42 under-speeding
```
