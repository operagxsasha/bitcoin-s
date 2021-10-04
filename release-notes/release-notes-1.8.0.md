# 1.8.0 DLC Wallet Tor negotiation

LAST COMMIT IS 6aff01ffbf
## Running Bitcoin-S

If you want to run the standalone server binary, after verifying gpg signatures, you
can `unzip bitcoin-s-server-1.7.0.zip` and then run it with `./bin/bitcoin-s-server` to start the node. You will need to
configure the node properly first, you can find example
configurations [here](https://bitcoin-s.org/docs/config/configuration#example-configuration-file).

You can then unzip the `bitcoin-s-cli-1.7.0.zip` folder and start using the `bitcoin-s-cli` like this:

```bashrc
./bin/bitcoin-s-cli --help
Usage: bitcoin-s-cli [options] [<cmd>]

  -n, --network <value>    Select the active network.
  --debug                  Print debugging information
  --rpcport <value>        The port to send our rpc request to on the server
  -h, --help               Display this help message and exit
```

For more information on what commands `bitcoin-s-cli` supports check the documentation, here is where to
start: https://bitcoin-s.org/docs/next/applications/server#server-endpoints

## Verifying signatures

This release is signed with [Chris's signing key](https://bitcoin-s.org/docs/next/security#disclosure) with
fingerprint `339A49229576050819083EB3F99724872F822910`

To do the verification, first hash the executable using `sha256sum`. You should check that the result is listed in
the `SHA256SUMS.asc` file next to its file name. After doing that you can use `gpg --verify` to authenticate the
signature.

Example:

UPDATE ME!!!!!!!
```
$ sha256sum bitcoin-s-server-1.7.0.tgz
aa1084edb5fcd3d1dbcafe0d0fba787abf4cd455bbe38809bd9a65a49c0cd0eb bitcoin-s-server-1.7.0.tgz
$ gpg --verify SHA256SUMS.asc
gpg: Signature made Thu 24 Sep 2020 12:49:39 PM CDT
gpg:                using RSA key 339A49229576050819083EB3F99724872F822910
gpg:                issuer "stewart.chris1234@gmail.com"
gpg: Good signature from "Chris Stewart <stewart.chris1234@gmail.com>"
```

### Website

https://bitcoin-s.org/

### Releases

https://repo1.maven.org/maven2/org/bitcoin-s/

### Snapshot releases

https://oss.sonatype.org/content/repositories/snapshots/org/bitcoin-s/

# Executive Summary

## app commons 

bfbde2abaa Add appCommonsTest to windows test matrix (#3683)

0fb2cd0149 Remove implicit conversions from BitcoinSAppConfig -> {WalletAppConfig,ChainAppConfig,NodeAppConfig} etc (#3652)

6ef30b4996 Add AppConfigFactory for DLCNodeAppConfig (#3598)

b980f4894d Implement BitcoinSAppConfig with ActorSystem (#3596)

75bbda66dd Add AppConfigActorSystem (#3590)

4f7b6422ea 2021 08 06 app config refacotr (#3498)

## App server

26d7f99173 2021 09 30 rename endpoints (#3703)

698fe9e800 Add backupwallet and backuporacle endpoints (#3694)

4a44f9cd58 Run appServerTest on both windows and mac (#3609)

2191eb2049 Add 'getversion' endpoint to fetch the version from the backend (#3689)

f5ed232946 Bump fee by more to make sure our fee rate is increasing the test case (#3625)

55c57c487e Add CORS handling for running from a local dev server (#3612)

a5f4f9663c Add BitcoinSServerMain test to connect to bitcoind (#3591)

9ef27e4d7e Turn on bitcoin-s.node.relay=true by default on bundle/appServer (#3580)

0a31d6a4e2 Have wallet broadcast transaction for sendrawtransaction (#3578)

309d9ec217 Add proxy and tor sections to reference conf (#3530)

7cac44de4d DLC P2P in AppServer and GUI (#3462)

5aac4fd8d5 Bump server startup timeout from 60 seconds to 120seconds (#3514)

e2c2798e60 Implemented the ability to fetch unconfirmed transactions (#3429)

## bitcoind rpc

781e77844f Implement ability to get proper version of BitcoindRpcClient from BitcoindRpcApConfig.clientF (#3699)

4e56fb7901 Make it so bitcoind backend exceptions don't get swallowed (#3697)

af96843e69 Try to fix race condition when shutting down bitcoind connection pool (#3665)

d53f164478 BitcoindRpcClient Improvements (#3600)

0746b14331 Move BitcoindRpcAppConfig into the bitcoind-rpc project (#3610)

## Build 

59e953a1fc Bump CI runs to use scalac 2.12.15 (#3700)

4ef1e6bcb6 CI fixes (#3597)

4a5265801c Allow for enternal entropy to be passed into a docker container for the appServer and oracleServer (#3679)

9b269f0e5e Change userId to work with umbrel (#3667)

cd9db4f4a9 Adjust the permissions of the statup script for the oracle server on docker so that any user can run the script (#3654)

e17ea32faa Update base docker image to openjdk:16-slim (#3650)

8e39b2bbb8 Sbt docker multi platform (#3649)

fd7cd71848 Update .gitmodules (#3390)

c774ce3a34 Implement logic to automatically attach deb,dmg,msi installers to a release when i tag something (#3388)

## Cli 

466de3e46a Update ConsoleCli endpoints, update docs (#3705)

515e85b1c5 Decode DLC messages cli commands (#3636)

40f89af597 Give help messages for DLC cli commands and document them (#3642)
## chain

fa45c74c36 Improve filter header verification (#3566)


## Core

ba713bd98f Fixed edge case of numeric range computation (#3707)

479f8e249c Remove unneeded CoreApi (#3599)

85eb2d5eb4 Fix approximateUtxoSize calculation for p2wpkh (#3669)

f3da45c504 Add CurrencyUnits.fromLong (#3653)

ba21c24d6f Give funding txid in DLC Signed state (#3640)

f2a2874177 Add new invalid BIP 32 test vectors (#3634)

6e41b76f5b Make test vector that times out on CI async (#3628)

e829d03249 Add better CETSignaturesV0TLV.toString so we don't accidentally DOS in the case of large amoutns of adaptor signatures (#3521)

462ffc53e6 Give TLVs subtypes, add LnMessage utilities (#3437)

2597904019 Move DLCWalletApi to core module (#3438)

9aa9a424c2 Implement init message from BOLT 1 (#3407)
## Db commons 

6df0354a73 Enable WAL mode for SQLite (#3704)

48213d9b81 Implement MasterXPubDAO (#3451)

bedc152f33 Write unit test for SpendingInfoDAO.upsert() (#3620)

b2b2ca45db Add ability to configure postgres database backends for test cases via reference.conf (#3421)

## DLC node

1051e6365a DLC P2P Client (#3402)

## DLC Oracle

98ecdf7ac3 Refactor DLCOracle construction to be more safe (#3449)

1032669f21 Add unit test for moving seeds and making sure we can get the same public key after moving (#3441)

36c4da7c95 Use AtomicInteger for keyIndex in DLCOracle (#3433)

2d96a9c519 Fix typo in DLCOracle (#3434)

91b88b60ec Add large digits test in DLCOracle (#3432)

ea1ead9a3f Add nonces to error message for easier debugging (#3430)

b7b2a7099f 2021 07 15 dlc oracle pg (#3413)


## DLC wallet 

099e4469b4 Add ordering of funding inputs to DLC Wallet (#3647)

706c9fe961 Add check for valid broadcast states (#3560)

1d6ede492f Invert updating of DLC state and broadcasting the funding tx (#3526)

621e8e9033 Rescan DLC Tests (#3515)

c1ce9ca115 Disallow signing your own DLCAccept (#3453)

a295b363bd Fix bug where we couldn't execute a DLC twice (#3426)

892096d790 Disallow calling addDLCSigs as Initiator (#3411)

## gui 

656e9b1b5d Sort DLC table by last updated (#3607)

11dd28085a Add debug window button to unreserve all utxos (#3633)

8cff5b6e33 Change bitcoind RPC Password to PasswordField (#3587)

e62615dc5e Add guard to not allow us to check the network configuration on bitcoind (#3582)

072c4164db Add Tor running text to UI (#3546)

68afe90778 Flip buttons for Offer and Accept (#3579)

01617be190 Add welcome pane to right view on startup (#3577)

fd02d3642e Add dialog to show transaction id and link after wallet Send (#3570)

5567d2214f Move DLC/Event loading operations to Pane (#3567)

589077f2f3 Enum outcome labels to match numeric outcome labels (#3568)

b545915fc0 Implement rebroadcast closing tx (#3564)

e08dc636a1 Wallet on top UI, minWidth on DLC View fields (#3540)

63ccfbe1a0 Add Network label to statusbar (#3541)

da0d583471 Style wallet startup screens (#3542)

e0ecafc5f9 Add debug window to view log fixes #3516 (#3536)

77539c570a Adjust DLCTableView column widths and "counter party" to "counterparty" (#3539)

b2065a9c02 SplitPane flat Dialog UI (#3505)

b98aa7c8e1 GUI code cleanup (#3504)

5524f7d393 Add style classes, center Rounding Info (#3496)

84e6097d48 Set disable to context menu items based on selection, add Refund/Execute (#3477)

e315fb0563 Move to GridPane wallet, dynamic sizing (#3492)

66813dc7c5 Fix error parsing address in AcceptOfferDialog (#3491)

831e0fd96d Evenly space footer status items (#3485)

3177b1586b Adds Tor Address to UI, if set (#3481)

2dd348a79f Fix dialog results optionality nesting to match dialogOpt (#3479)

00841160e0 Modifer keys per OS, Mac native menubar (#3474)

ef16082b95 Add preferences for wallet window x,y,w,h persistence (#3473)

c022261c4f Remove colons from DLC view labels (#3471)

9aadf9053d Dialogs to CliCommandProducers with buildView(), common fileChooser (#3456)

bc3140c6bb Default Use Tor to config value, space login pages the same (#3472)

f20cdf667c Pretty print PnL in table view (#3400)

19fb1cf17a Add network selection combobox for Neutrino (#3409)

c1715760c6 Add connection indicator to GUI (#3381)

## keymanager 

132479d271 Implement ability to provide external entropy to bitcoin-s (#3672)

## Lnd rpc
f6169cc3af Add LndInstanceRemote (#3710)

26efbe783e Add lnd close channel function (#3692)

4f65022472 Fix signet parsing of LnInvoices (#3691)

e6e1fbdab8 Fix typo for signet LndInstances (#3690)

b6f28456e2 Add functions for Lease & Release output functions (#3677)

fd6e0864ac LndRpcClient: Fix listUnspent only showing unconfirmed utxos (#3663)

74777a9683 Add conversion utils for LndRpcClient (#3660)

5089e901bb Add wallet signing functions (#3658)

7cd21edb12 2021 08 17 rebroadcast funding tx (#3561)

35d2c6db4e Update LND to v0.13.1-beta (#3435)

## node 

db46e35172 Fix case where we forget to correctly assign currentPeerMsgHandlerRecv (#3662)

b6ef27eb3e Move block generation and synchronization of th wallet before clearing utxo/addresses (#3623)

ac8bdb120c Implement PeerMessageReceiverState.InitializedDisconnect. This allows us to distinguish between disconnections we initalized and connections the peer intialized. This is needed for determining whether we should reconnect or not (#3583)

20575bcd68 Fix missing afterAll in ReConnectionTest (#3584)

54ce2ebeb2 P2P reconnect logic (#3572)

114fbf35fe Update version, userAgent for bitcoin-s (#3565)

037ab7341e Reduce logs for inv messages and wallet callbacks to DEBUG (#3524)

1426c31483 Multi peer: Sync with random peer (#3454)

85975b8b07 complete handshake with peers (#3446)

4be2b2109b [WIP] Adding multi-peer support (#3401)

1c6d728197 Made relay flag in version message configurable (#3416)

45233be22d Update user agent (#3384)

## Oracle server

6aff01ffbf createattesattion -> signenum (#3712)

3d725adc92 2021 09 29 delete announcement (#3701)

27d4c09d37 Add sha256 announcement/event ids on oracleServer 'getevent' for use in UI (#3673)

## secp256k1jni 

60dbd0252d Update secp256k1 precompiled binaries to use safegcd code on linux64 (#3528)

560edf66d8 update osx64 secp256k1 binaries (#3531)

e3ab76fe6b update arm64 secp256k1 binaries (#3527)

## wallet 

1f35dbdb85 Fix bug where we weren't waiting on a future to complete in for expression (#3627)

184bf415df More bitcoind backend wallet tests (#3605)

f85f969500 Revert 60 second delay on broadcast to go back to 4 hour default to not break IBD (#3557)

9666e9d296 2021 08 09 init delay broadcast freq (#3509)

## testkit

2c8a2b0e32 Fix testkit depending on slf4j twice (#3644)

495ab62104 Tor in Testkit (#3484)

902f4aa332 The spaces after the log level cause logging levels not to work (#3545)

## tor 

704b02ae6c Use random ports for pre-packaged Tor daemon (#3604)

cebd289dd6 Implement versioning for packaged tor (#3576)

c915711908 Make Tor setup Docker compatible (#3552)

addb1254ee Fix for if tor is already running (#3562)

f2e68bbfc5 Add guard for the case where tor binary hasn't created log file yet (#3558)

b7d85264a0 Implement TorAppConfig.start(), use tor logs to detect when the tor is fully started (#3549)

bbd3cd2bc4 Stop tor binary when server is shutdown (#3543)

04678b5ed9 Add tor config to bundle application.conf (#3537)

ddd27c3d89 Add TorBundle, make all mac files executable that are required (#3534)

43e0287fed Package Tor with Bitcoin-s (#3483)

3d4cf1fc91 Tor support for all sub-projects (#3506)

8979ac2932 Don't use tor proxy for localhost connections (#3500)

b39ca47268 Create TorAppConfig (#3476)

59963156bc Hidden service setup helper (#3423)

ca40af5d94 Tor support for BTC RPC (#3470)

16e8554756 SOCKS5 client transport (#3396)

8b663d91b6 Tor support for P2P (#3311)


## Website

d2a7bc02b6 Fix app server docker docs (#3575)

7f7bc1f4bf Update configuration.md (#3503)

6a66f9bfcd Update tor.md (#3507)

c27291a7a2 Getting Setup Fixes (#3517)

c37f982f02 Update tor.md (#3495)

a8fa96b0a4 Add where tor.md modifications need to be made explicitly (#3493)

e61be252bd Updated README (#3489)

79e11c6dce Update path to secp256k1 library in docs (#3385)


## Dependencies

51bf5458dc Update metrics-core to 4.2.4 (#3709)
bf16bab881 Update scodec-bits to 1.1.29 (#3698)
f9cfd05414 Update postgresql to 42.2.24 (#3687)
c17cc86ad6 Update sbt-ci-release to 1.5.9 (#3685)
c53b96c77f Update native-lib-loader to 2.4.0 (#3682)
9b429e98da Bump prismjs from 1.24.0 to 1.25.0 in /website (#3680)
dc56c69c6a Update scalafx to 16.0.0-R25 (#3676)
b80710eaaf Update native-lib-loader to 2.3.6 (#3678)
619fd5a1fb Update scalatest to 3.2.10 (#3675)
3c64af39d9 Update sbt-scoverage to 1.9.0 (#3671)
11c3626fac Update sbt-bloop to 1.4.9 (#3664)
87b8c4a138 Update scala-library to 2.12.15 (#3668)
911fd3429d Update scala-async to 1.0.1 (#3656)
576680a419 Update logback-classic to 1.2.6 (#3655)
14ea28bfa2 Update akka-grpc-runtime_2.12, ... to 2.1.0 (#3638)
3c9b30b974 Update scodec-bits to 1.1.28 (#3639)
2d429db60d Update sqlite-jdbc to 3.36.0.3 (#3630)
554869e72a Update akka-actor, akka-discovery, ... to 2.6.16 (#3574)
168da1ae1e Update sbt-mdoc to 2.2.23 (#3613)
0200ae8beb Update sqlite-jdbc to 3.36.0.2 (#3608)
90c3f69713 Update scalajs-stubs to 1.1.0 (#3508)
004b6cc59d Update sbt-scalajs, scalajs-compiler, ... to 1.7.0 (#3475)
fc88aa077b Update sbt-mdoc to 2.2.22 (#3439)
3cdc0d19c7 Update akka-http, akka-http-testkit, ... to 10.2.6 (#3488)
520e8e5715 Update janino to 3.1.6 (#3457)
07b4e722c1 Update akka-http, akka-http-testkit, ... to 10.2.5 (#3455)
7b1c5639cc Update logback-classic to 1.2.5 (#3452)
62a8897d7f Update slf4j-api to 1.7.32 (#3427)
7f07ed7a7a Update metrics-core to 4.2.3 (#3419)
6e04010cba Update scala-async to 1.0.0 (#3392)
74964ab145 Update sbt to 1.5.5 (#3391)
cddecc2075 Update sbt-scalafmt to 2.4.3 (#3386)
38c55ad0c0 Update scala-collection-compat to 2.5.0 (#3387)