package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves = switch (type) {
            case KING -> kingMoves(board, myPosition);
            case QUEEN -> queenMoves(board, myPosition);
            case BISHOP -> bishopMoves(board, myPosition);
            case KNIGHT -> knightMoves(board, myPosition);
            case ROOK -> rookMoves(board, myPosition);
            case PAWN -> pawnMoves(board, myPosition);
        };
        return moves;
    }

    /**
     * Calculates all the positions a king can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    private Collection<ChessMove> kingMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves = new ArrayList<>();

        // move up (only if in bounds, not blocked by own piece) (it can move up if there is an enemy piece)
        if (myPosition.getRow() < 8 && (board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn())) == null || board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn())).getTeamColor() != pieceColor)) {
            moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn()), null));
        }

        // move down (only if in bounds, not blocked by own piece) (it can move down if there is an enemy piece)
        if (myPosition.getRow() > 1 && (board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn())) == null || board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn())).getTeamColor() != pieceColor)) {
            moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn()), null));
        }

        // move left (only if in bounds, not blocked by own piece) (it can move left if there is an enemy piece)
        if (myPosition.getColumn() > 1 && (board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn() - 1)) == null || board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn() - 1)).getTeamColor() != pieceColor)) {
            moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn() - 1), null));
        }

        // move right (only if in bounds, not blocked by own piece) (it can move right if there is an enemy piece)
        if (myPosition.getColumn() < 8 && (board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn() + 1)) == null || board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn() + 1)).getTeamColor() != pieceColor)) {
            moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn() + 1), null));
        }

        // move up left (only if in bounds, not blocked by own piece) (it can move up left if there is an enemy piece)
        if (myPosition.getRow() < 8 && myPosition.getColumn() > 1 && (board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1)) == null || board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1)).getTeamColor() != pieceColor)) {
            moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1), null));
        }

        // move up right (only if in bounds, not blocked by own piece) (it can move up right if there is an enemy piece)
        if (myPosition.getRow() < 8 && myPosition.getColumn() < 8 && (board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1)) == null || board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1)).getTeamColor() != pieceColor)) {
            moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1), null));
        }

        // move down left (only if in bounds, not blocked by own piece) (it can move down left if there is an enemy piece)
        if (myPosition.getRow() > 1 && myPosition.getColumn() > 1 && (board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1)) == null || board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1)).getTeamColor() != pieceColor)) {
            moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1), null));
        }

        // move down right (only if in bounds, not blocked by own piece) (it can move down right if there is an enemy piece)
        if (myPosition.getRow() > 1 && myPosition.getColumn() < 8 && (board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1)) == null || board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1)).getTeamColor() != pieceColor)) {
            moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1), null));
        }

        return moves;
    }

    /**
     * Calculates all the positions a queen can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    private Collection<ChessMove> queenMoves(ChessBoard board, ChessPosition myPosition) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Calculates all the positions a bishop can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    private Collection<ChessMove> bishopMoves(ChessBoard board, ChessPosition myPosition) {
        // TODO: Implement
        throw new RuntimeException("Not implemented");
    }

    /**
     * Calculates all the positions a knight can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    private Collection<ChessMove> knightMoves(ChessBoard board, ChessPosition myPosition) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Calculates all the positions a rook can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    private Collection<ChessMove> rookMoves(ChessBoard board, ChessPosition myPosition) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Calculates all the positions a pawn can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    private Collection<ChessMove> pawnMoves(ChessBoard board, ChessPosition myPosition) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChessPiece that)) return false;
        return pieceColor == that.pieceColor && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, type);
    }

    @Override
    public String toString() {
        return switch (type) {
            case KING -> pieceColor == ChessGame.TeamColor.WHITE ? "♔" : "♚";
            case QUEEN -> pieceColor == ChessGame.TeamColor.WHITE ? "♕" : "♛";
            case BISHOP -> pieceColor == ChessGame.TeamColor.WHITE ? "♗" : "♝";
            case KNIGHT -> pieceColor == ChessGame.TeamColor.WHITE ? "♘" : "♞";
            case ROOK -> pieceColor == ChessGame.TeamColor.WHITE ? "♖" : "♜";
            case PAWN -> pieceColor == ChessGame.TeamColor.WHITE ? "♙" : "♟";
        };
    }
}
