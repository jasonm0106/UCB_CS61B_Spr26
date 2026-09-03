## Step 1 Create personal Github repo
https://github.com/jasonm0106/UCB_CS61B_Spr26

## Step 2 Set up Git
```
git config --global user.name "yijunm"
git config --global user.email "bournemao@gmail.com"
git config --global init.defaultBranch main
git config --global core.editor "nano -w"
```

## Step 3 Authenticate to GitHub
run below command to retrieve and run a remote shell script which checks if public key exists locally and creates one if not
```
curl -sS --ssl-no-revoke https://sp26.datastructur.es/assets/homeworks/hw01/get-ssh-key.sh | bash
```

run `ssh -T git@github.com` to test whether your computer can successfully authenticate with GitHub using your SSH key. If it failed with below error message
```
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@       WARNING: POSSIBLE DNS SPOOFING DETECTED!          @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
The RSA host key for github.com has changed,
and the key for the corresponding IP address 140.82.116.4
is unknown. This could either mean that
DNS SPOOFING is happening or the IP address for the host
and its host key have changed at the same time.
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@    WARNING: REMOTE HOST IDENTIFICATION HAS CHANGED!     @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
IT IS POSSIBLE THAT SOMEONE IS DOING SOMETHING NASTY!
Someone could be eavesdropping on you right now (man-in-the-middle attack)!
It is also possible that a host key has just been changed.
The fingerprint for the RSA key sent by the remote host is
SHA256:uNiVztksCsDhcc0u9e8BujQXVUpKZIDTMczCvj3tD2s.
Please contact your system administrator.
Add correct host key in /Users/myj/.ssh/known_hosts to get rid of this message.
Offending RSA key in /Users/myj/.ssh/known_hosts:2
RSA host key for github.com has changed and you have requested strict checking.
Host key verification failed.
```

That means the local computer saved GitHub's public key years ago while GitHub officially updated its cryptographic host keys in 2023. During connectivity, local computer received GitHub's new key and found it did not match the old key saved in /Users/myj/.ssh/known_hosts. The local computer aborted the connection as it assumed a hacker might be intercepting your Internet traffic.

The fix is to clear the old key and generate a new one by connecting again
```
(base)  ✘ myj@Yijuns-MacBook-Pro  ~/cs61b  ssh-keygen -R github.com

# Host github.com found: line 2
/Users/myj/.ssh/known_hosts updated.
Original contents retained as /Users/myj/.ssh/known_hosts.old
(base)  myj@Yijuns-MacBook-Pro  ~/cs61b  ssh -T git@github.com
The authenticity of host 'github.com (140.82.116.3)' can't be established.
ECDSA key fingerprint is SHA256:p2QAMXNIC1TJYWeIOttrVc98/R1BUFWu3/LiyKgUfQM.
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added 'github.com,140.82.116.3' (ECDSA) to the list of known hosts.
Hi jasonm0106! You've successfully authenticated, but GitHub does not provide shell access.
```

## Step 4 Clone repos
clone library files to local
```
git clone git@github.com:Berkeley-CS61B/library-sp26.git
```

clone personal repo to local
```
git clone git@github.com:jasonm0106/UCB_CS61B_Spr26.git
(base)  myj@Yijuns-MacBook-Pro  ~/cs61b  ls -a
.               ..              UCB_CS61B_Spr26 library-sp26
```

link the official Berkeley repo website address to local Git with nick name "skeleton"
```
git remote add skeleton git@github.com:Berkeley-CS61B/skeleton-sp26.git
```

download and merge the Berkeley files into your personal repo
```
git pull skeleton main --allow-unrelated-histories
```
