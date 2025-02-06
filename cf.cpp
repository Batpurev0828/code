#include <iostream>
#include <vector>
using namespace std;
#define ll long long

int main() {
    ll n, lim;
    cin >> n >> lim;
    ll mx = 0;
    vector<ll> nums(n);
    for (ll &i: nums) {
        cin >> i;
        mx = max(mx, i);
    }
    vector<ll> occ(mx + 1, 0);
    auto check = [&](ll cnt) -> bool {
        return cnt <= lim;
    };
    auto add = [&](ll r, ll &cnt) -> void {
        ++occ[r];
        if (occ[r] == 1) {
            ++cnt;
        }
    };
    auto remove = [&](ll l, ll &cnt) -> void {
        --occ[l];
        if (occ[l] == 0) {
            --cnt;
        }
    };
    ll res = 0;
    for (ll r = 0, l = 0, cnt = 0; r<n; r++) {
        add(nums[r], cnt);
        while (!check(cnt)) {
            remove(nums[l++], cnt);
        }
        res += r - l + 1;
    }   
    cout << res << '\n';
    return 0;
}
