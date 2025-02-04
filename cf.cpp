#include <iostream>
#include <vector>
// #include <unordered_map>
#define ll long long
using namespace std;

signed main() {
    ll n, lim;
    cin >> n >> lim;
    vector<ll> nums(n);
    for (ll &i: nums) cin >> i;
    ll res = 0;
    for (ll r = 0, l = 0, sum = 0; r < n; ++r) {
        sum += nums[r];
        while (sum - nums[l] >= lim) {
            sum -= nums[l];
            ++l;
        }
        if (sum >= lim) {
            res += r - l + 1;
        }
    }
    cout << ((res == 1e18) ? -1 : res) << '\n';
}