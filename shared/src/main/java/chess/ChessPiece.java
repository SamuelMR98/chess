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

    ChessGame.TeamColor pieceColor;
    PieceType type;

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
        // Move up
        if (myPosition.getRow() < 8) {
            ChessPosition up = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn());
            ChessPiece upPiece = board.getPiece(up);
            // If there is no piece there, or there is an enemy piece there
            if (upPiece == null || upPiece.getTeamColor() != pieceColor) {
                moves.add(new ChessMove(myPosition, up, null));
            }
        }
        // Move down
        if (myPosition.getRow() > 1) {
            ChessPosition down = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn());
            ChessPiece downPiece = board.getPiece(down);
            // If there is no piece there, or there is an enemy piece there
            if (downPiece == null || downPiece.getTeamColor() != pieceColor) {
                moves.add(new ChessMove(myPosition, down, null));
            }
        }
        // Move left
        if (myPosition.getColumn() > 1) {
            ChessPosition left = new ChessPosition(myPosition.getRow(), myPosition.getColumn() - 1);
            ChessPiece leftPiece = board.getPiece(left);
            // If there is no piece there, or there is an enemy piece there
            if (leftPiece == null || leftPiece.getTeamColor() != pieceColor) {
                moves.add(new ChessMove(myPosition, left, null));
            }
        }
        // Move right
        if (myPosition.getColumn() < 8) {
            ChessPosition right = new ChessPosition(myPosition.getRow(), myPosition.getColumn() + 1);
            ChessPiece rightPiece = board.getPiece(right);
            // If there is no piece there, or there is an enemy piece there
            if (rightPiece == null || rightPiece.getTeamColor() != pieceColor) {
                moves.add(new ChessMove(myPosition, right, null));
            }
        }
        // Move up-left
        if (myPosition.getRow() < 8 && myPosition.getColumn() > 1) {
            ChessPosition upLeft = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1);
            ChessPiece upLeftPiece = board.getPiece(upLeft);
            // If there is no piece there, or there is an enemy piece there
            if (upLeftPiece == null || upLeftPiece.getTeamColor() != pieceColor) {
                moves.add(new ChessMove(myPosition, upLeft, null));
            }
        }
        // Move up-right
        if (myPosition.getRow() < 8 && myPosition.getColumn() < 8) {
            ChessPosition upRight = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1);
            ChessPiece upRightPiece = board.getPiece(upRight);
            // If there is no piece there, or there is an enemy piece there
            if (upRightPiece == null || upRightPiece.getTeamColor() != pieceColor) {
                moves.add(new ChessMove(myPosition, upRight, null));
            }
        }
        // Move down-left
        if (myPosition.getRow() > 1 && myPosition.getColumn() > 1) {
            ChessPosition downLeft = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1);
            ChessPiece downLeftPiece = board.getPiece(downLeft);
            // If there is no piece there, or there is an enemy piece there
            if (downLeftPiece == null || downLeftPiece.getTeamColor() != pieceColor) {
                moves.add(new ChessMove(myPosition, downLeft, null));
            }
        }
        // Move down-right
        if (myPosition.getRow() > 1 && myPosition.getColumn() < 8) {
            ChessPosition downRight = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1);
            ChessPiece downRightPiece = board.getPiece(downRight);
            // If there is no piece there, or there is an enemy piece there
            if (downRightPiece == null || downRightPiece.getTeamColor() != pieceColor) {
                moves.add(new ChessMove(myPosition, downRight, null));
            }
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
        Collection<ChessMove> moves = new ArrayList<>();
        // Move up
        if (myPosition.getRow() < 8) {
            ChessPosition up = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn());
            ChessPiece upPiece = board.getPiece(up);
            // If there is no piece there
            if (upPiece == null) {
                moves.add(new ChessMove(myPosition, up, null));
            }
        }
        // Move up-left
        if (myPosition.getRow() < 8 && myPosition.getColumn() > 1) {
            ChessPosition upLeft = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1);
            ChessPiece upLeftPiece = board.getPiece(upLeft);
            // If there is an enemy piece there
            if (upLeftPiece != null && upLeftPiece.getTeamColor() != pieceColor) {
                moves.add(new ChessMove(myPosition, upLeft, null));
            }
        }
        // Move up-right
        if (myPosition.getRow() < 8 && myPosition.getColumn() < 8) {
            ChessPosition upRight = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1);
            ChessPiece upRightPiece = board.getPiece(upRight);
            // If there is an enemy piece there
            if (upRightPiece != null && upRightPiece.getTeamColor() != pieceColor) {
                moves.add(new ChessMove(myPosition, upRight, null));
            }
        }
        return moves;
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
