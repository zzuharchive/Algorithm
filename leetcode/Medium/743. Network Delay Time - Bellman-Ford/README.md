# [Medium] Network Delay Time - 743

[문제 링크](https://leetcode.com/problems/network-delay-time/)

### 성능 요약

<img width="394" height="214" alt="Image" src="https://github.com/user-attachments/assets/a94ede30-2c2e-4190-8dd7-364e4a2b9108" />

### 문제 풀이 방식

벨만포드 => 가중치가 `0 ~ 100`으로 제약되어 있기 때문에, 음수 사이클 체크는 구현 안함. 

### 제출 일자

2026년 7월 4일

### description

You are given a network of `n` nodes, labeled from `1` to `n`. You are also given `times`, a list of travel times as directed edges `times[i] = (ui, vi, wi)`, where u<sub>i</sub> is the source node, v<sub>i</sub> is the target node, and w<sub>i</sub> is the time it takes for a signal to travel from source to target.

We will send a signal from a given node `k`. Return the **_minimum_** time it takes for all the `n` nodes to receive the signal. If it is impossible for all the `n` nodes to receive the signal, return `-1`.



**Example 1:**

<img width="198" height="194" alt="image" src="https://github.com/user-attachments/assets/1784e83f-a614-4764-88ac-4b9f8aa6a975" />

> **Input:** times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
> **Output:** 2

**<br>Example 2:**

> **Input:** times = [[1,2,1]], n = 2, k = 1
> **Output:** 1

**<br>Example 3:**

> **Input:** times = [[1,2,1]], n = 2, k = 2
> **Output:** -1


**Constraints:**

- `1 <= k <= n <= 100`
- `1 <= times.length <= 6000`
- `times[i].length == 3`
- `1 <= ui, vi <= n`
- `ui != vi`
- `0 <= wi <= 100`
- All the pairs `(ui, vi)` are **unique**. (i.e., no multiple edges.)