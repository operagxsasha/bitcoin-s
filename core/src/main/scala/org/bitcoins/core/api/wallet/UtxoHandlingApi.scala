package org.bitcoins.core.api.wallet

import org.bitcoins.core.api.wallet.db.SpendingInfoDb
import org.bitcoins.core.currency.CurrencyUnit
import org.bitcoins.core.hd.HDAccount
import org.bitcoins.core.protocol.script.ScriptPubKey
import org.bitcoins.core.protocol.transaction.{Transaction, TransactionOutPoint}
import org.bitcoins.core.wallet.utxo.{AddressTag, TxoState}

import scala.concurrent.{ExecutionContext, Future}

trait UtxoHandlingApi {

  /** Removes all utxos from the wallet. Don't call this unless you are sure you
    * can recover your wallet
    */
  def clearAllUtxos(): Future[Unit]

  def clearAllAddresses(): Future[Unit]

  /** Finds all the outputs in our wallet being spent in the given transaction
    */
  def findOutputsBeingSpent(tx: Transaction): Future[Vector[SpendingInfoDb]]

  def findByScriptPubKey(
      scriptPubKey: ScriptPubKey): Future[Vector[SpendingInfoDb]]

  def findByOutPoints(
      outPoints: Vector[TransactionOutPoint]): Future[Vector[SpendingInfoDb]]

  final def findByOutPoint(outPoint: TransactionOutPoint)(implicit
      ec: ExecutionContext): Future[Option[SpendingInfoDb]] = {
    findByOutPoints(Vector(outPoint)).map(_.headOption)
  }

  def getUnconfirmedBalance(tag: AddressTag): Future[CurrencyUnit]
  def getConfirmedBalance(tag: AddressTag): Future[CurrencyUnit]
  final def getBalance(tag: AddressTag)(implicit
      ec: ExecutionContext): Future[CurrencyUnit] = {
    val uF = getUnconfirmedBalance(tag)
    val cF = getConfirmedBalance(tag)
    for {
      u <- uF
      c <- cF
    } yield u + c
  }

  def listDefaultAccountUtxos(): Future[Vector[SpendingInfoDb]]

  /** Lists unspent transaction outputs in the wallet
    * @return
    *   Vector[SpendingInfoDb]
    */
  def listUtxos(): Future[Vector[SpendingInfoDb]]

  def listUtxos(tag: AddressTag): Future[Vector[SpendingInfoDb]]

  def listUtxos(state: TxoState): Future[Vector[SpendingInfoDb]]

  def listUtxos(account: HDAccount): Future[Vector[SpendingInfoDb]]

  def listUtxos(
      hdAccount: HDAccount,
      tag: AddressTag): Future[Vector[SpendingInfoDb]]

  def listUtxos(
      hdAccount: HDAccount,
      state: TxoState): Future[Vector[SpendingInfoDb]]

  def listUtxos(
      outPoints: Vector[TransactionOutPoint]
  ): Future[Vector[SpendingInfoDb]]

  def markUTXOsAsReserved(
      utxos: Vector[SpendingInfoDb]): Future[Vector[SpendingInfoDb]]

  /** Marks all utxos that are ours in this transactions as reserved */
  def markUTXOsAsReserved(tx: Transaction): Future[Vector[SpendingInfoDb]]

  def unmarkUTXOsAsReserved(
      utxos: Vector[SpendingInfoDb]): Future[Vector[SpendingInfoDb]]

  /** Unmarks all utxos that are ours in this transactions indicating they are
    * no longer reserved
    */
  def unmarkUTXOsAsReserved(tx: Transaction): Future[Vector[SpendingInfoDb]]

  /** Takes in a block header and updates our TxoStates to the new chain tip
    * @param blockHeader
    *   Block header we are processing
    */
  def updateUtxoPendingStates(): Future[Vector[SpendingInfoDb]]
}